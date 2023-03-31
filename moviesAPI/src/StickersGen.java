import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class StickersGen {
    public void cria() throws Exception {
        // Leitura da imagem

        BufferedImage imagemOriginal = ImageIO.read(new File("media/TopMovies_1.jpg"));

        // Criar nova imagem em memória com tamanho novo e transparência

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0, null );

        // Escrever uma frase na nova imagem

        // Escrever a imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("media/figurinha.png"));

    }

    public static void main(String[] args) throws Exception {
        StickersGen stickers = new StickersGen();
        stickers.cria();
    }
}
