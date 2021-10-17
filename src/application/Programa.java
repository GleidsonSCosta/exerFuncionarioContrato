package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import enums.Nivel;

public class Programa {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//armazenando os valores digitados e guardando em variáveis
		System.out.print("Digite o nome do departamento: ");
		String nomeDep = sc.nextLine();		
		System.out.println("Dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrab = sc.nextLine();
		System.out.print("Nivel:");
		String niv = sc.nextLine().toUpperCase();		
		System.out.print("Digite o salário base: ");
		Double salBase = sc.nextDouble();
		
		//intanciando um objeto e passando os parâmetros com o valor da variáveis  
		Trabalhador trabalhador = new Trabalhador(nomeTrab, Nivel.valueOf(niv), salBase, new Departamento(nomeDep));
		
		
		System.out.print("Quantos contratos o trabalhador pussui?");
		Integer n = sc.nextInt();
		
		// realizando um FOR para percorrer a quantidade informada e coletando os dados 
		//armazenando os valores digitados e guardando em variáveis
		//instanciando o objeto passando os parâmetros, contrato e adicionando na lista de contratos
		//coletando a data e formatando
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Dados do contrato: " + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Quantidades de hora do contrato: ");
			int qtdHoras = sc.nextInt();
			
			HoraContrato contrato = new HoraContrato(dataContrato, valorHora, qtdHoras);
			trabalhador.addContrato(contrato);
		}
		
		
		//recebendo a string com mes e ano, recontando e transormando em variáveis do tipos inteiro
		
		System.out.println();
		System.out.print("Selecione um mês e ano (MM/YYYY): ");
		String mes_Ano = sc.next();
		int mes = Integer.parseInt(mes_Ano.substring(0,2));
		int ano = Integer.parseInt(mes_Ano.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Ganhos referente a " + mes_Ano + ": " + String.format("%.2f", trabalhador.ganhos(mes, ano)));
		
		
		
		sc.close();

	}

}
