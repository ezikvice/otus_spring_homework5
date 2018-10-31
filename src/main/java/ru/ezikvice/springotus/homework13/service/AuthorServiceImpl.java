package ru.ezikvice.springotus.homework13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ezikvice.springotus.homework13.dao.AuthorRepository;
import ru.ezikvice.springotus.homework13.domain.Author;

import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final JdbcMutableAclService aclService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, JdbcMutableAclService aclService) {
        this.authorRepository = authorRepository;
        this.aclService = aclService;
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Transactional
    @Override
    public Author save(Author author) {

//    // Prepare the information we'd like in our access control entry (ACE)
//        ObjectIdentity oi = new ObjectIdentityImpl(Author.class, author.getId());
//        Sid sid = new PrincipalSid("ROLE_AUTHOR_EDITOR");
//        Permission permission = BasePermission.ADMINISTRATION;
//
//    // Create or update the relevant ACL
//        MutableAcl acl = null;
//        try {
//            acl = (MutableAcl) aclService.readAclById(oi);
//        } catch (NotFoundException nfe) {
//            acl = aclService.createAcl(oi);
//        }
//
//        // Now grant some permissions via an access control entry (ACE)
//        acl.insertAce(acl.getEntries().size(), permission, sid, true);
//        aclService.updateAcl(acl);
//
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Set<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }
}
