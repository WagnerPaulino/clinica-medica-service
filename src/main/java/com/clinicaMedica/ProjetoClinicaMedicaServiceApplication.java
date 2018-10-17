package com.clinicaMedica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.clinicaMedica.domain.Login;
import com.clinicaMedica.domain.Proprietario;
import com.clinicaMedica.services.LoginService;

/*Para testar, comente nas classes a linha 
 * @GeneratedValue(strategy = GenerationType.AUTO)
 */
@SpringBootApplication
@EnableCaching
public class ProjetoClinicaMedicaServiceApplication implements CommandLineRunner {

	// @Autowired
	// private MedicoService medicoService;
//	@Autowired
//	private ProprietarioService proprietarioService;
	// @Autowired
	// private ConsultaService consultaService;
	//
	// @Autowired
	// private PacienteService pacienteService;
	//
	// @Autowired
	// private RecepcionistaService recepcionistaService;

	@Autowired
	private LoginService loginService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoClinicaMedicaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Proprietario p = new Proprietario();
		p.setNome("Adm");
		Login l = new Login();
		l.setUsuario("adm");
		l.setSenha("adm");
		p.setLogin(l);
		l.setProprietario(p);
		if (loginService.sign(l.getUsuario(), l.getSenha()) == null) {
			this.loginService.save(l);
		}
		// double x = 1.70;
		// int y = 12;
		// Consulta consulta = new Consulta(1L, "X", "X", "X", "X", "X", "X", x, x, y,
		// "X", "X", x);
		// consultaService.insert(consulta);
		// Proprietario proprietario = new Proprietario();
		// proprietario.setId(1L);
		// proprietario.setNome("X");
		// proprietarioService.insert(proprietario);
		// Medico medico = new Medico(1321, "X");
		// medico.setId(1L);
		// medico.setNome("X");
		// medico.setConsultas(Arrays.asList(consulta));
		// medico.setProprietario(proprietario);
		// medicoService.insert(medico);
		// Paciente paciente = new Paciente();
		// paciente.setIdPaciente(1L);
		// paciente.setNome("X");
		// pacienteService.insert(paciente);
		// Recepcionista recepcionista = new Recepcionista();
		// recepcionista.setId(1L);
		// recepcionista.setNome("X");
		// recepcionista.setPacientes(Arrays.asList(paciente));
		// recepcionistaService.insert(recepcionista);
	}
}
