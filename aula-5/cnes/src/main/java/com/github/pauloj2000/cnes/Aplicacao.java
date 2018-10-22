package com.github.augustomoura.cnes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class Aplicacao {

  public static void main(final String[] args) throws IOException {
    final AppArguments arguments = new AppArguments(args);

    if (arguments.isAskingHelp()) {
      printHelp();
      return;
    }

    final OutputStream out = new FileOutputStream(arguments.getOutUrl().toFile());

    final EstabelecimentosFileResolver resolver = new EstabelecimentosFileResolver(
        arguments.getInUrl(), out);

    System.out.println(
        "Iniciando processamento, isso pode demorar alguns minutos " +
            "dependendo do tamanho do arquivo, aguarde por favor...");

    resolver.resolveAndWrite();
  }

  private static void printHelp() {
    final StringBuilder sb = new StringBuilder()
        .append(System.lineSeparator())
        .append("RESUMO:").append(System.lineSeparator())
        .append(System.lineSeparator())
        .append("    Baixa informações sobre a base de dados CNES, descompacta, lê o arquivo de ").append(System.lineSeparator())
        .append("  estabelecimentos, retira as informações de código CNES, razão social, latitude").append(System.lineSeparator())
        .append("  e longitude e exporta em um arquivo JSON").append(System.lineSeparator())
        .append(System.lineSeparator())
        .append(System.lineSeparator())
        .append(" ARGUMENTOS: [ARQUIVO] [OPCOES]...").append(System.lineSeparator())
        .append(System.lineSeparator())
        .append("     \"ARQUIVO\" pode ser uma url remota ou local").append(System.lineSeparator())
        .append(System.lineSeparator())
        .append(System.lineSeparator())
        .append(" Opções:").append(System.lineSeparator())
        .append(System.lineSeparator())
        .append("  --out, -o").append(System.lineSeparator())
        .append("      Caminho de saída onde o arquivo json será escrito").append(System.lineSeparator())
        .append(System.lineSeparator())
        .append("  --help, -h").append(System.lineSeparator())
        .append("      Imprime essa tela de ajuda").append(System.lineSeparator())
        .append(System.lineSeparator());

    System.out.println(sb.toString());
  }

}
