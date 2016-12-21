/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propriedades;

import Elementos.Casa;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexandrepimenta
 */
public class Leitores 
{
    
    public static ArrayList<Casa> carregarCasas() throws FileNotFoundException
    {
        ArrayList<Casa> entrada = new ArrayList<>();
        //ABRE O ARQUIVO, REALIZA A LEITURA ADICIONANDO AS CASAS
        Scanner scan = new Scanner(new File("coords.txt"));
        int x1,x2,y1,y2;
        String line;
        String[] separator;
        //LE AS CARTAS DE CIMA
        int index = 0;
        while(scan.hasNext() && index < 10)
        {
            line = scan.nextLine();
            //PULAR AS PARTES COMENTADAS
            if(line.contains("//"))
            {
                line = scan.nextLine();
            }
            separator = line.split(",");

            x1 = Integer.parseInt(separator[0]);
            x2 = Integer.parseInt(separator[1]);
            y1 = Integer.parseInt(separator[2]);
            y2 = Integer.parseInt(separator[3]);
            //ADICIONAR CARTAS DE CIMA
            entrada.add(new Casa(x1,x2,y1,y2));
            index++;
        }
        index = 11;
        while(scan.hasNext() && index < 20)
        {
            line = scan.nextLine();
            //PULAR AS PARTES COMENTADAS
            if(line.contains("//"))
            {
                line = scan.nextLine();
            }
            separator = line.split(",");

            x1 = Integer.parseInt(separator[0]);
            x2 = Integer.parseInt(separator[1]);
            y1 = Integer.parseInt(separator[2]);
            y2 = Integer.parseInt(separator[3]);
            //ADICIONAR CARTAS DE CIMA
            entrada.add(new Casa(x1,x2,y1,y2));
            index++;
        }
        //
        index = 31;
        while(scan.hasNext() && index > 21)
        {
            line = scan.nextLine();
            //PULAR AS PARTES COMENTADAS
            if(line.contains("//"))
            {
                line = scan.nextLine();
            }
            separator = line.split(",");

            x1 = Integer.parseInt(separator[0]);
            x2 = Integer.parseInt(separator[1]);
            y1 = Integer.parseInt(separator[2]);
            y2 = Integer.parseInt(separator[3]);
            //ADICIONAR CARTAS DE CIMA
            entrada.add(new Casa(x1,x2,y1,y2));
            index--;
        }
        //
        index = 39;
        while(scan.hasNext() && index < 31)
        {
            line = scan.nextLine();
            //PULAR AS PARTES COMENTADAS
            if(line.contains("//"))
            {
                line = scan.nextLine();
            }
            separator = line.split(",");

            x1 = Integer.parseInt(separator[0]);
            x2 = Integer.parseInt(separator[1]);
            y1 = Integer.parseInt(separator[2]);
            y2 = Integer.parseInt(separator[3]);
            //ADICIONAR CARTAS DE CIMA
            entrada.add(new Casa(x1,x2,y1,y2));
            index--;
        }
        //DEPOIS RETORNA A LISTA
        return entrada;
    }
}
