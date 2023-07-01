package acmestore;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import acmestore.model.entities.Assinatura;
import acmestore.model.entities.Cliente;
import acmestore.model.entities.Pagamento;
import acmestore.model.entities.Produto;
import acmestore.model.entities.builders.AssinaturaBuilder;
import acmestore.model.entities.enums.AssinaturaType;
import acmestore.model.exceptions.FileException;

public class App {
	public static void main(String[] args) {
		
		/*
		 * 1 - Crie uma Classe com um método main para criar alguns produtos, clientes e
		 * pagamentos. Crie Pagamentos com: a data de hoje, ontem e um do mês passado.
		 */
		Cliente pedro = new Cliente("Pedro Gonçalves de Souza Melo");
		Cliente rodrigo = new Cliente("Rodrigo Marques Valares");
		Cliente joao = new Cliente("João Meloso Neto");
		Cliente henrique = new Cliente("Henrique Cardoso de Holanda");
		Cliente tiago = new Cliente("Tiago Humberto Lopes");
		Cliente luiza = new Cliente("Luiza Bonança de Melo");
		Cliente rose = new Cliente("Rose das Rosas de Orvalho");
		Cliente valeria = new Cliente("Valéria Cardoso de Holanda");
		Cliente joana = new Cliente("Joana Melosa Neta");
		Cliente meire = new Cliente("Meire de Nobrega Brega");

		Path file = null;

		try {
			file = Paths.get(App.class.getClassLoader().getResource("productFile.txt").toURI());
		} catch (URISyntaxException e) {
			throw new FileException("Erro na sintaxe do caminho (path) do arquivo", e);
		}

		if (file != null) {
			Produto p1 = new Produto("Samsung Notebook", file, BigDecimal.valueOf(3400.00));
			Produto p2 = new Produto("Lenovo Ideapad 3", file, BigDecimal.valueOf(2800.00));
			Produto p3 = new Produto("Xioami Poc X5", file, BigDecimal.valueOf(1615.89));
			Produto p4 = new Produto("IPhone 14 Pro", file, BigDecimal.valueOf(10499.99));
			Produto p5 = new Produto("JBL Wind 2", file, BigDecimal.valueOf(215.15));
			Produto p6 = new Produto("Relógio Golden Hour", file, BigDecimal.valueOf(189.90));
			Produto p7 = new Produto("Memória RAM 16GB p/ Notebook", file, BigDecimal.valueOf(259.60));
			Produto p8 = new Produto("Perfume Ferrari Black", file, BigDecimal.valueOf(199.00));
			Produto p9 = new Produto("IPad Pro", file, BigDecimal.valueOf(8974.99));
			Produto p10 = new Produto("Box Trilogia Ascenção - Isaac Asimov", file, BigDecimal.valueOf(215.15));

			List<Produto> cP = new ArrayList<>();
			cP.add(p1);
			cP.add(p5);
			cP.add(p6);

			List<Produto> cR = new ArrayList<>();
			cR.add(p10);
			cR.add(p6);
			cR.add(p7);
			cR.add(p2);

			List<Produto> cJ = new ArrayList<>();
			cJ.add(p4);

			List<Produto> cH = new ArrayList<>();
			cH.add(p3);
			cH.add(p8);

			List<Produto> cT = new ArrayList<>();
			cT.add(p10);
			cT.add(p5);

			List<Produto> cL = new ArrayList<>();
			cL.add(p9);

			List<Produto> cRs = new ArrayList<>();
			cRs.add(p9);
			cRs.add(p6);
			cRs.add(p8);
			cRs.add(p1);
			cRs.add(p3);

			List<Produto> cV = new ArrayList<>();
			cV.add(p1);

			List<Produto> cJo = new ArrayList<>();
			cJo.add(p4);
			cJo.add(p10);

			List<Produto> cM = new ArrayList<>();
			cM.add(p10);

			Pagamento pagPedro = new Pagamento(cP, LocalDateTime.now(), pedro);
			Pagamento pagRodrigo = new Pagamento(cR, LocalDateTime.now(), rodrigo);
			Pagamento pagJoao = new Pagamento(cJ, LocalDate.now().atTime(12, 15), joao);
			Pagamento pagHenrique = new Pagamento(cH, LocalDateTime.now().plusHours(1), henrique);
			Pagamento pagTiago = new Pagamento(cT, LocalDateTime.now().minusDays(1), tiago);
			Pagamento pagLuiza = new Pagamento(cL, LocalDate.now().minusDays(1).atTime(12, 0), luiza);
			Pagamento pagRose = new Pagamento(cRs, LocalDate.now().plusDays(1).atTime(16, 15), rose);
			Pagamento pagValeria = new Pagamento(cV, LocalDate.now().minusMonths(1).atStartOfDay(), valeria);
			Pagamento pagJoana = new Pagamento(cJo, LocalDateTime.now().minusDays(1), joana);
			Pagamento pagMeire = new Pagamento(cM, LocalDate.now().minusMonths(1).atTime(15, 0), meire);

			List<Pagamento> pagamentos = new ArrayList<>();
			pagamentos.add(pagPedro);
			pagamentos.add(pagRodrigo);
			pagamentos.add(pagJoao);
			pagamentos.add(pagHenrique);
			pagamentos.add(pagTiago);
			pagamentos.add(pagLuiza);
			pagamentos.add(pagRose);
			pagamentos.add(pagValeria);
			pagamentos.add(pagJoana);
			pagamentos.add(pagMeire);

			/*
			 * 2 - Ordene e imprima os pagamentos pela data de compra.
			 */
			System.out.println("------- Ordenados -------");

			Comparator<Pagamento> dateComparator = Comparator.comparing(Pagamento::getDataCompra);
			TreeSet<Pagamento> pagamentosOrdenados = new TreeSet<>(dateComparator);
			pagamentosOrdenados.addAll(pagamentos);

			for (Pagamento p : pagamentosOrdenados) {
				System.out.println(p);
			}

			/*
			 * 3 - Calcule e Imprima a soma dos valores de um pagamento com optional e
			 * recebendo um Double diretamente. !!! (Dúvida)
			 */
			System.out.println("\n------- Soma de um Pagamento -------");
			BigDecimal sum = pagamentosOrdenados.last().getProdutos().stream()
					.map(Produto::getPreco).reduce(BigDecimal.valueOf(0.0), BigDecimal::add);
			System.out.println("Soma do valor de um pagamento: " + Assinatura.formatBigDecimal(sum));

			/*
			 * 4 - Calcule o Valor de todos os pagamentos da Lista de pagamentos.
			 */
			System.out.println("\n------- Soma de cada pagamento -------");
			pagamentos.forEach(p -> System.out.println("Cliente: " + p.getCliente().getName() + ", total: "
					+ Assinatura.formatBigDecimal(p.getProdutos().stream()
							.map(Produto::getPreco).reduce(BigDecimal.valueOf(0.0), BigDecimal::add))));

			/*
			 * 5 - Imprima a quantidade de cada Produto vendido.
			 */
			System.out.println("\n------- Quantidade de cada produto -------");
			Map<Produto, Integer> quantidadeProdutos = pagamentos.stream().flatMap(p -> p.getProdutos().stream())
					.collect(Collectors.groupingBy(produto -> produto, Collectors.summingInt(produto -> 1)));
			for (Map.Entry<Produto, Integer> entry : quantidadeProdutos.entrySet()) {
				System.out.println(entry.getKey().getNome() + ", quantidade: " + entry.getValue());
			}

			/*
			 * 6 - Crie um Mapa de <Cliente, List<Produto> , onde Cliente pode ser o nome do
			 * cliente.
			 */
			Map<Cliente, List<Produto>> productsByClient = pagamentos.stream().collect(Collectors.groupingBy(
					Pagamento::getCliente, Collectors.flatMapping(p -> p.getProdutos().stream(), Collectors.toList())));

			/*
			 * 7 - Qual cliente gastou mais?
			 */
			System.out.println("\n------- Cliente que mais gastou -------");
			Map<Cliente, BigDecimal> totalByClient = new HashMap<>();
			for (Map.Entry<Cliente, List<Produto>> entry : productsByClient.entrySet()) {
				Cliente c = entry.getKey();
				List<Produto> p = entry.getValue();
				BigDecimal total = calcularTotal(p);
				totalByClient.put(c, total);
			}

			Cliente c = Collections.max(totalByClient.entrySet(), Map.Entry.comparingByValue()).getKey();
			BigDecimal most = totalByClient.get(c);

			System.out.println(
					"Cliente: " + c.getName() + ", total: " + Assinatura.formatBigDecimal(most));

			/*
			 * 8 - Quanto foi faturado em um determinado mês?
			 */
			System.out.println("\n------- Faturação por mês -------");
			Map<Month, BigDecimal> totalByMonth = new EnumMap<>(Month.class);
			for (Pagamento p : pagamentos) {
				Month m = p.getDataCompra().getMonth();
				BigDecimal total = calcularTotal(p.getProdutos());
				BigDecimal totalMes = totalByMonth.getOrDefault(m, BigDecimal.ZERO);
				totalMes = totalMes.add(total);

				totalByMonth.put(m, totalMes);
			}

			totalByMonth.entrySet().stream().forEach(x -> System.out
					.println(x.getKey() + ", valor total: " + Assinatura.formatBigDecimal(x.getValue())));

			/*
			 * 9 - Crie 3 assinaturas com assinaturas de 99.98 reais, sendo 2 deles com
			 * assinaturas encerradas.
			 */
			BigDecimal valorAssinatura = BigDecimal.valueOf(99.98);

			Assinatura a1 = new AssinaturaBuilder(valorAssinatura).setBegin(LocalDateTime.now().minusYears(4))
					.setCliente(pedro).setAtraso(false).setTipo(AssinaturaType.ANUAL).getEntity();
			Assinatura a2 = new AssinaturaBuilder(valorAssinatura).setBegin(LocalDateTime.now().minusYears(1))
					.setEnd(LocalDateTime.now().minusHours(1)).setCliente(rodrigo).setAtraso(false)
					.setTipo(AssinaturaType.SEMESTRAL).getEntity();
			Assinatura a3 = new AssinaturaBuilder(valorAssinatura).setBegin(LocalDateTime.now().minusWeeks(8))
					.setEnd(LocalDateTime.now().minusHours(1)).setCliente(joana).setAtraso(false)
					.setTipo(AssinaturaType.TRIMESTRAL).getEntity();

			List<Assinatura> assinaturas = new ArrayList<>();
			assinaturas.add(a1);
			assinaturas.add(a2);
			assinaturas.add(a3);


			/*
			 * 10 - Imprima o tempo em meses de alguma assinatura ainda ativa.
			 */
			System.out.println("\n------- Tempo em meses de assinaturas ativas -------");
			assinaturas.stream().filter(a -> a.getEnd().isEmpty()).forEach(
					ass -> System.out.println("Cliente: " + ass.getCliente().getName() + ", tempo de assinatura: "
							+ ChronoUnit.MONTHS.between(ass.getBegin(), LocalDateTime.now()) + " meses."));

			/*
			 * 11 - Imprima o tempo de meses entre o start e end de todas assinaturas. Não
			 * utilize IFs para assinaturas sem end Time.
			 */
			System.out.println("\n------- Tempo em meses entre start e end de todas assinaturas -------");
			assinaturas.forEach(App::calcularDiferencaMeses);

			/*
			 * 12 - Calcule o valor pago em cada assinatura até o momento.
			 */
			System.out.println("\n------- Valor total por assinatura -------");
			assinaturas.forEach(Assinatura::exibirTotalAssinatura);

			/*
			 * --------- INÍCIO LISTA 2 -----------
			 */
			System.out.println("\n------- Taxa por assinatura -------");
			assinaturas.forEach(a -> System.out
					.println(Assinatura.formatBigDecimal(a.calcularTaxa(Assinatura.calcularTotalAssinatura(a)))));

		}
	}

	public static BigDecimal calcularTotal(List<Produto> list) {
		return list.stream().map(Produto::getPreco).reduce(BigDecimal.valueOf(0.0), BigDecimal::add);
	}

	public static void calcularDiferencaMeses(Assinatura a) {
		LocalDateTime b = a.getBegin();
		LocalDateTime e = a.getEnd().orElse(LocalDateTime.now());

		System.out.println(ChronoUnit.MONTHS.between(b, e));
	}
}