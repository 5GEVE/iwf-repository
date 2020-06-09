package it.cnit.iwf_repository.vim;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "vimAccounts", path = "vimAccounts")
public interface VimAccountRepository extends PagingAndSortingRepository<VimAccount, Long> {

  List<VimAccount> findByTypeIgnoreCase(@Param("type") String type);

  List<VimAccount> findByVimAccountNfvoId(@Param("uuid") UUID uuid);
}
