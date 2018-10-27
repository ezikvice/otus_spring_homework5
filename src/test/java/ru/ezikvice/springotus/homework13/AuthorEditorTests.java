package ru.ezikvice.springotus.homework13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.ezikvice.springotus.homework13.domain.Author;
import ru.ezikvice.springotus.homework13.service.AuthorService;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorEditorTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = {"AUTHOR_EDITOR"})
    public void
    givenRoleAuthorEditor_whenSaveAuthor_thenOk() throws Exception {
        this.mockMvc.perform(post("/authors/add")
        .param("name","test author"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"AUTHOR_EDITOR"})
    public void
    givenRoleAuthorEditor_whenSaveGenre_thenForbidden() throws Exception {
        this.mockMvc.perform(post("/genres/add")
        .param("name","test genre")
        .param("description", "test description"))
                .andExpect(status().isForbidden());
    }

}
