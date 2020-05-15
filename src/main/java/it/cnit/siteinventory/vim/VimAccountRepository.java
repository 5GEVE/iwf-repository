package it.cnit.siteinventory.vim;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "vimAccounts", path = "vimAccounts")
public interface VimAccountRepository extends PagingAndSortingRepository<VimAccount, Long> {

  List<VimAccount> findByTypeIgnoreCase(@Param("type") String type);
}
