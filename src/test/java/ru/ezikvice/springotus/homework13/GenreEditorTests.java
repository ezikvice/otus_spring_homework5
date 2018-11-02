package ru.ezikvice.springotus.homework13;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.ezikvice.springotus.homework13.domain.Author;
import ru.ezikvice.springotus.homework13.service.AuthorService;
import ru.ezikvice.springotus.homework13.service.AuthorServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class GenreEditorTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorService authorService;

    private Author a;

    @Before
    @WithMockUser(username = "ua", roles = {"AUTHOR_EDITOR"})
    public void setAuthor(){
        a = authorService.save(new Author("testid", "pushkin"));
    }

    @Test
    @WithMockUser(username = "ug", roles = {"GENRE_EDITOR"})
    public void
    givenRoleGenreEditor_whenSaveGenre_thenOk() throws Exception {
        this.mockMvc.perform(post("/genres/add")
                .param("name", "test genre")
                .param("description", "test description"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "ug", roles = {"GENRE_EDITOR"})
    public void
    givenRoleGenreEditor_whenSaveGenre_thenForbidden() throws Exception {

        this.mockMvc.perform(post("/authors/testid/edit")
                .param("name", "PUSHKING"))
                .andExpect(status().isForbidden());
    }

}
