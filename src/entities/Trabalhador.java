package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.Nivel;

public class Trabalhador {

	// ### ATRIBUTOS ###

	private String nome;
	private Nivel nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HoraContrato> contratos = new ArrayList<>();

	
	// ### CONSTRUTORES ###
public Trabalhador() {
	
}

	public Trabalhador(String nome, Nivel nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}



	// ### GET - SET ###
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}



	// ### MÉTODOS ###

	
	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double ganhos(int mes, int ano) {
		double soma = salarioBase;

		Calendar cal = Calendar.getInstance();

		for (HoraContrato c : contratos) {

			cal.setTime(c.getDate());

			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);

			if (ano == c_ano && mes == c_mes) {
				soma += c.totalContrato();
			}
		}
		return soma;
	}



}