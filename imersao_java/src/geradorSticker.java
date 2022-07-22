import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class geradorSticker {

    public void cria(InputStream inputStream, String nomeAquivo, String dir) throws IOException {
        // leitura da imagem
        // InputStream inputImg = new FileInputStream(new File("img/cancer.jpg"));
        // BufferedImage inputImg = ImageIO.read("img/cancer.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMGEzN2VkMmUtMGM1Zi00Y2U1LTlkMDktMTlhMTdmYzZmZDlhXkEyXkFqcGdeQXVyODEyNjEwMDk@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem em memoria com tranparencia e com tamanha novo
        int largura1 = imagemOriginal.getWidth();
        int altura1 = imagemOriginal.getHeight();
        // int largura2 = inputImg.getWidth();
        // int altura2 = inputImg.getHeight();
        int novaAltura = altura1 + 40;
        BufferedImage novaImagem =  new BufferedImage(largura1, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem 
        Graphics2D graphics =(Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        // configurar fonte
        Font font = new Font(Font.SERIF, Font.BOLD, 17);
        graphics.setColor(Color.CYAN);
        graphics.setFont(font);

        // escrever frase na nova imagem
        graphics.drawString("Este produto", 5, novaAltura-15);
        graphics.drawString("causa cancer", 6, novaAltura-5);

        // escrever a nova img em arquivo
        String path = dir + nomeAquivo;
        ImageIO.write(novaImagem, "png", new File(path));
    }
}

