package it.cnit.siteinventory.vim;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "vims", path = "vims")
public interface VimRepository extends PagingAndSortingRepository<Vim, Long> {
    List<Vim> findByTypeIgnoreCase(@Param("type") String type);
}
