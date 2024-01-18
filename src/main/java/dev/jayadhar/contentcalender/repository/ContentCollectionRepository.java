package dev.jayadhar.contentcalender.repository;

import dev.jayadhar.contentcalender.model.Content;
import dev.jayadhar.contentcalender.model.Status;
import dev.jayadhar.contentcalender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();
    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c = new Content(1, "title", "desc", Status.DRAFT, Type.BLOG, LocalDateTime.now(), null, "");
        contentList.add(c);
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().anyMatch(c -> c.id().equals(id));
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
