package com.clinicaMedica.repositorys;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinicaMedica.domain.Consulta;
import com.clinicaMedica.projections.CountConsultaProximosDias;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	@Query(" select count(c.id) as count, c.dtConsulta as dtConsulta from Consulta c where c.dtConsulta > CURRENT_DATE and coalesce(c.realizada,false) = false group by c.dtConsulta order by c.dtConsulta asc ")
	public List<CountConsultaProximosDias> countConsultasProximosDias();
	
	@Query(" select c from Consulta c where c.dtConsulta between ?1 and ?2 or c.dtRetorno between ?3 and ?4 ")
	public List<Consulta> findConsultaByPeriodo(LocalDate dtConsultaIni, LocalDate dtConsultaFim , LocalDate dtRetornoIni, LocalDate dtRetornoFim);

}
