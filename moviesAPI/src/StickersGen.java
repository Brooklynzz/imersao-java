import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickersGen {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // Leitura da imagem
//        InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Criar nova imagem em memória com tamanho novo e transparência
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para a nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0, null );

        // Configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.yellow);

        // Escrever uma frase na nova imagem
        graphics.drawString("TOPZERA",200, novaAltura - 100);

        // Escrever a imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("media/saida/" + nomeArquivo + ".png"));

    }
}
