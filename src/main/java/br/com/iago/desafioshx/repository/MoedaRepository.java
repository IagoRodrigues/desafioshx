package br.com.iago.desafioshx.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.iago.desafioshx.model.Moeda;

public interface MoedaRepository extends JpaRepository<Moeda, Long> {
	
	/**
	 * This method make the PS/SQL select to bring the currency by date</br>
	 * 
	 * @param dataInicial (From date)
	 * @param dataFinal (To date)
	 * @return List of Moeda between dataInicial and dataFinal
	 */
	@Query("SELECT m FROM Moeda m WHERE m.time_stamp BETWEEN :dataInicial AND :dataFinal")
	List<Moeda> findPorData(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);
}
