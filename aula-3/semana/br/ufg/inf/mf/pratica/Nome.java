package br.ufg.inf.mf.pratica;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Nome {

  public static void main(String[] args){
    System.out.println(
		LocalDate.now()
			.getDayOfWeek()
			.getDisplayName(TextStyle.FULL, Locale.getDefault()));
  } 
   
}

