/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.core.project.bussinesLogic;

import com.org.core.project.dto.Caso;
import com.org.core.project.dto.InformacaoDoLog;
import com.org.core.project.dto.InformacaoHardwareDto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GerenciadorDeLog {

    public String path;

    public GerenciadorDeLog() {
        criarPastaDoRelatorio();
    }

    public void EscreveLog(InformacaoDoLog informacaoDoLog) {
        // Caminho do arquivo
        String caminhoDoArquivo = path + "\\relatorioSort.txt";

        InformacaoHardwareDto informacaoHardwareDto = getHardwareInformation();

        // Texto a ser adicionado
        ArrayList<String> textoParaAdicionar = new ArrayList();
        int count = 1;
        textoParaAdicionar.add("INFORMAÇÂO HARDWARE");
        textoParaAdicionar.add("CPU : " + informacaoHardwareDto.getCpu());
        textoParaAdicionar.add("MEMORIA : " + informacaoHardwareDto.getMemoria());
        textoParaAdicionar.add("SISTEMA OPERACIONAL : " + informacaoHardwareDto.getSistemaOperacional());        
        textoParaAdicionar.add("\n");
         for(Caso caso : informacaoDoLog.getCasos()){
         textoParaAdicionar.add("ALGORITIMO : " + informacaoDoLog.getAlgoritimo().getValue());
         textoParaAdicionar.add("CASO "+ count +" : " +  caso.getDescCaso());
         textoParaAdicionar.add("DATA INICIO : "+new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(caso.getDateInicio()));         
         textoParaAdicionar.add("DATA FIM : "+new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(caso.getDateFim()));
         textoParaAdicionar.add("DURACAO TOTAL : " + caso.getTotal()+" MS ");
         textoParaAdicionar.add("\n");
         count++;
         }
          textoParaAdicionar.add(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        

        for (String texto : textoParaAdicionar) {
            // Tente abrir o arquivo para escrita, com a opção de anexar (true)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDoArquivo, true))) {
                // Adicione o texto ao arquivo
                writer.write(texto);
                // Adicione uma quebra de linha para separar as informações
                writer.newLine();

                System.out.println("Texto adicionado ao arquivo com sucesso.");
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        }
        
    }

    public void criarPastaDoRelatorio() {
        // Obtém o diretório home do usuário
        String diretorioUsuario = System.getProperty("user.home");

        // Concatena o caminho para o diretório "Documents"
        String caminhoDocuments = diretorioUsuario + File.separator + "Documents";

        // Nome da nova pasta a ser criada
        String nomeNovaPasta = "ProjetoAnaliseSort";

        // Concatena o caminho completo para a nova pasta
        String caminhoNovaPasta = caminhoDocuments + File.separator + nomeNovaPasta;

        path = caminhoNovaPasta;

        // Cria um objeto File representando a nova pasta
        File novaPasta = new File(caminhoNovaPasta);

        // Verifica se a pasta já existe
        if (novaPasta.exists()) {
            System.out.println("A pasta já existe em " + caminhoNovaPasta);
        } else {
            // Tenta criar a nova pasta
            if (novaPasta.mkdir()) {
                System.out.println("Pasta criada com sucesso em: " + caminhoNovaPasta);
            } else {
                System.err.println("Não foi possível criar a pasta.");
            }
        }
    }

    public InformacaoHardwareDto getHardwareInformation() {
        long totalPhysicalMemorySize = 0L;
        InformacaoHardwareDto informacaoHardwareDto = new InformacaoHardwareDto();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        // Verifica se a classe OperatingSystemMXBean suporta a obtenção da memória total
        if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
            totalPhysicalMemorySize = ((com.sun.management.OperatingSystemMXBean) osBean).getTotalPhysicalMemorySize();
            System.out.println("Memória RAM Total: " + formatBytes(totalPhysicalMemorySize));
        } else {
            System.out.println("A classe OperatingSystemMXBean não fornece informações detalhadas sobre a memória.");
        }

        informacaoHardwareDto.setMemoria( formatBytes(totalPhysicalMemorySize));
        informacaoHardwareDto.setSistemaOperacional(operatingSystemMXBean.getName() + " ARCH" + operatingSystemMXBean.getArch());
        informacaoHardwareDto.setCpu(getProcessadorName());

        return informacaoHardwareDto;

    }

    private static String formatBytes(long bytes) {
        long kilobytes = bytes / 1024;
        long megabytes = kilobytes / 1024;
        return megabytes + " MB";
    }

    private String getProcessadorName() {
        String resultado = "";
        String os = System.getProperty("os.name");

        if (os.toLowerCase().contains("win")) {
            // Se estiver executando no Windows, obtemos o nome do processador usando a classe System
            String processor = System.getenv("PROCESSOR_IDENTIFIER");
            System.out.println("Nome do Processador: " + processor);
            resultado = processor;
        } else {
            // Para sistemas não-Windows, usamos a classe OperatingSystemMXBean
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
            System.out.println("Nome do Processador: " + operatingSystemMXBean.getArch());
            resultado = operatingSystemMXBean.getArch();
        }
        return resultado;

    }

}
