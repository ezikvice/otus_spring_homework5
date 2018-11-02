package ru.ezikvice.springotus.homework13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.*;
import org.springframework.security.acls.mongodb.MongoDBMutableAclService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ezikvice.springotus.homework13.dao.AuthorRepository;
import ru.ezikvice.springotus.homework13.domain.Author;

import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    MongoDBMutableAclService aclService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Transactional
    @Override
    public Author save(Author author) {

        ObjectIdentity oi = new ObjectIdentityImpl(Author.class, author.getId());
        Sid sid = new PrincipalSid("ROLE_AUTHOR_EDITOR");
        Permission permission = BasePermission.WRITE;

        MutableAcl acl;
        try {
            acl = (MutableAcl) aclService.readAclById(oi);
        } catch (NotFoundException nfe) {
            acl = aclService.createAcl(oi);
        }

        acl.insertAce(acl.getEntries().size(), permission, sid, true);
        aclService.updateAcl(acl);

        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author findById(String id) {
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
