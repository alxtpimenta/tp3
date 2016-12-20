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
    
    public static void carregarSprites() throws IOException
    {
    	//modificar caminho da imagem (estava dando problema no meu computador)
        Sprites.planoDeFundo = ImageIO.read(new File("C:/Users/SALA/workspace/BancoImobiliario/src/Imagens/background.png"));
        Sprites.jogadorAmarelo = ImageIO.read(new File("C:/Users/SALA/workspace/BancoImobiliario/src/Imagens/amarelo.png"));
        Sprites.jogadorAzul = ImageIO.read(new File("C:/Users/SALA/workspace/BancoImobiliario/src/Imagens/azul.png"));
        Sprites.jogadorBranco = ImageIO.read(new File("C:/Users/SALA/workspace/BancoImobiliario/src/Imagens/branco.png"));
        Sprites.jogadorPreto = ImageIO.read(new File("C:/Users/SALA/workspace/BancoImobiliario/src/Imagens/preto.png"));
        Sprites.jogadorVerde = ImageIO.read(new File("C:/Users/SALA/workspace/BancoImobiliario/src/Imagens/verde.png"));
        Sprites.jogadorVermelho = ImageIO.read(new File("C:/Users/SALA/workspace/BancoImobiliario/src/Imagens/vermelho.png"));
    }
}
