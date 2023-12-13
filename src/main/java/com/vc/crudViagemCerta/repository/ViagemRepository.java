
package com.vc.crudViagemCerta.repository;

import com.vc.crudViagemCerta.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository  extends JpaRepository<Viagem, Integer>{
    
}
