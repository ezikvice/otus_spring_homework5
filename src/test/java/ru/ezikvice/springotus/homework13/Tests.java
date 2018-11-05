package ru.ezikvice.springotus.homework13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.MutableAcl;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.Sid;
import org.springframework.security.acls.mongodb.MongoDBMutableAclService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.ezikvice.springotus.homework13.domain.Author;
import ru.ezikvice.springotus.homework13.domain.Genre;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class Tests {

    @Autowired
    private MockMvc mockMvc;
    private static boolean isAuthorGranted = false;
    private static boolean isGenreGranted = false;
    @Autowired
    private MongoDBMutableAclService aclService;


    @Test
    @WithMockUser(username = "ua", roles = "AUTHOR_EDITOR")
    public void setAuthorGrantsAndTest() throws Exception {

        if (!isAuthorGranted) {
            ObjectIdentity oi = new ObjectIdentityImpl(Author.class, "testid");
            Sid authorSid = new PrincipalSid("ua");
            MutableAcl acl;
            try {
                acl = (MutableAcl) aclService.readAclById(oi);
            } catch (NotFoundException nfe) {
                acl = aclService.createAcl(oi);
            }

            acl.insertAce(acl.getEntries().size(), BasePermission.ADMINISTRATION, authorSid, true);
            acl.insertAce(acl.getEntries().size(), BasePermission.READ, authorSid, true);
            acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, authorSid, true);
            acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, authorSid, true);


            aclService.updateAcl(acl);
            isAuthorGranted = true;
        }
        this.mockMvc.perform(post("/authors/testid/edit")
                .param("name", "test author"))
                .andExpect(status().isOk());

    }

    @Test
    @WithMockUser(username = "ug", authorities = {"GENRE_EDITOR"})
    public void
    setGenreGrantsAndTest() throws Exception {
        if (!isGenreGranted) {
            ObjectIdentity oi = new ObjectIdentityImpl(Genre.class, "testid");
            Sid genreSid = new PrincipalSid("ug");
            MutableAcl acl;
            try {
                acl = (MutableAcl) aclService.readAclById(oi);
            } catch (NotFoundException nfe) {
                acl = aclService.createAcl(oi);
            }

            acl.insertAce(acl.getEntries().size(), BasePermission.ADMINISTRATION, genreSid, false);
            acl.insertAce(acl.getEntries().size(), BasePermission.READ, genreSid, false);
            acl.insertAce(acl.getEntries().size(), BasePermission.WRITE, genreSid, false);
            acl.insertAce(acl.getEntries().size(), BasePermission.CREATE, genreSid, false);


            aclService.updateAcl(acl);
            isGenreGranted = true;
        }

        this.mockMvc.perform(post("/authors/testid/edit")
                .param("name", "test author forbidden"))
                .andExpect(status().isForbidden());
    }
}
