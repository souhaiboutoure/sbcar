package sn.estm.sbcar2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.estm.sbcar2.domain.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
