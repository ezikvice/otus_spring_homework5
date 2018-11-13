package ru.ezikvice.springotus.homework13.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.ezikvice.springotus.homework13.domain.Book;

import javax.sql.DataSource;
import java.net.UnknownHostException;
import java.util.HashMap;

@EnableBatchProcessing
@Configuration
@EnableAutoConfiguration
public class BatchConfig {
    private final Logger logger = LoggerFactory.getLogger("Batch");

    private ContextConfig ctx;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    public BatchConfig(ContextConfig ctx) {
        this.ctx = ctx;
    }

    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.addScript("classpath:schema-h2.sql")
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }

    @Bean
    public MongoItemReader<Book> bookReader() {
        MongoItemReader<Book> reader = new MongoItemReader<Book>();
        try {
            reader.setTemplate(ctx.mongoTemplate());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        reader.setCollection("book");
        reader.setTargetType(Book.class);
        reader.setQuery("{'_id':{$ne:null} }");
        reader.setSort(new HashMap<String, Sort.Direction>(){{put("id", Sort.Direction.ASC);}});
        return  reader;
    }

    @Bean
    public ItemProcessor bookProcessor() {
        return new ItemProcessor<Book, Book>() {
            @Override
            public Book process(Book book) throws Exception {
                logger.info(book.toString());
                return book;
            }
        };
    }

    @Bean
    public JdbcBatchItemWriter<Book> bookWriter() {
        JdbcBatchItemWriter<Book> itemWriter = new JdbcBatchItemWriter<Book>();
        itemWriter.setDataSource(dataSource());
        itemWriter.setSql("INSERT INTO BOOK (id, name, description) VALUES (:id, :name, :description)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Book>());
        return itemWriter;
    }

//    @Autowired
//    EntityManagerFactory emf;
//    @Bean
//    public JpaItemWriter writer() {
//        JpaItemWriter writer = new JpaItemWriter();
//        writer.setEntityManagerFactory(emf);
//        return writer;
//    }

    @Bean
    public Job importUserJob(Step step) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter writer) {
        return stepBuilderFactory.get("step1")
                .chunk(5)
                .reader(bookReader())
                .processor(bookProcessor())
                .writer(writer)
                .build();
    }
}
