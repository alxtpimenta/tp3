/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author alexandrepimenta
 */
public class Sprites 
{
    //TABULEIRO
    public static BufferedImage planoDeFundo;
    //PEOES DO JOGAODR
    public static BufferedImage jogadorAzul;
    public static BufferedImage jogadorAmarelo;
    public static BufferedImage jogadorVermelho;
    public static BufferedImage jogadorPreto;
    public static BufferedImage jogadorBranco;
    public static BufferedImage jogadorVerde;
    //CASAS E HOTEIS
    public static BufferedImage casa;
    public static BufferedImage hotel;
    
    public static void carregarSprites() throws IOException
    {
        Sprites.planoDeFundo = ImageIO.read(new File("background.png"));
        Sprites.jogadorAmarelo = ImageIO.read(new File("amarelo.png"));
        Sprites.jogadorAzul = ImageIO.read(new File("azul.png"));
        Sprites.jogadorBranco = ImageIO.read(new File("branco.png"));
        Sprites.jogadorPreto = ImageIO.read(new File("preto.png"));
        Sprites.jogadorVerde = ImageIO.read(new File("verde.png"));
        Sprites.jogadorVermelho = ImageIO.read(new File("vermelho.png"));
    }
}
