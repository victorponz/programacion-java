import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Ejercicio2_1 {
	public static void main(String[] args) throws IOException {
		
		File f = new File("./penyagolosa.bmp");
		
		TransformaImagen ti = new TransformaImagen(f);
		
		ti.transformaNegativo();
		ti.transformaOscuro();
		ti.transformaBlancoNegro();
		//ti.transformaBlancoNegroByte();
	}
	
}
class TransformaImagen {
	File f = null;

	public TransformaImagen(File fEnt) {
		// Control de existencia del fichero y control de la extensión .bmp (sacar
		// mensajes de error)
		if (fEnt.exists()) {
			if (fEnt.isFile()) {
				if (fEnt.getName().endsWith(".bmp")) {
					f = fEnt;
				} else {
					System.out.println("El archivo no es de tipo bmp");
				}
			} else {
				System.out.println("El archivo no es un fichero");
			}
		} else {
			System.out.println("El fichero no existe");
		}

	}

	public void transformaNegativo() throws IOException {
		// Transformar a negativo y guardar como *_n.bmp
		
		File fsal = new File(f.getParentFile().getCanonicalPath() + "/" +  getNombreSinExtension() + "_n.bmp");
		//sSystem.out.println(getNombreSinExtension());
		FileInputStream imagen = new FileInputStream(this.f);
		FileOutputStream imagenSalida = new FileOutputStream(fsal);

		// Leemos y escribimos los primeros 54 bytes (información de la imagen)

		byte[] buffer = new byte[54];
		imagen.read(buffer);
		imagenSalida.write(buffer);

		// Ahora leemos byte a byte a partir del 54
		int num = imagen.read();
		while (num != -1) {
			imagenSalida.write(255 - num);
			if (num < 0)
				System.out.println(num);
			num = imagen.read();
		}

		imagen.close();
		imagenSalida.close();

	}
	public void transformaOscuro() throws IOException {
		// Transformar a una imagen más oscura y guardar como *_o.bmp
		File fsal = new File(f.getParentFile().getCanonicalPath() + "/" +  getNombreSinExtension() + "_o.bmp");
		FileInputStream imagen = new FileInputStream(this.f);
		FileOutputStream imagenSalida = new FileOutputStream(fsal);

		// Leemos y escribimos los primeros 54 bytes (información de la imagen)

		byte[] buffer = new byte[54];
		imagen.read(buffer);
		imagenSalida.write(buffer);

		// Ahora leemos byte a byte a partir del 54
		int num;
		while (imagen.available()> 0) {
			num = imagen.read();
			imagenSalida.write(num / 2);
			
		}
		/*while (num != -1) {
			imagenSalida.write(num / 2);
			num = imagen.read();
		}*/

		imagen.close();
		imagenSalida.close();
	}
	public void transformaBlancoNegro() throws IOException {
		// Transformar a una imagen en blanco y negro y guardar como *_bn.bmp

		File fsal = new File(f.getParentFile().getCanonicalPath() + "/" +  getNombreSinExtension() + "_bn.bmp");
		FileInputStream imagen = new FileInputStream(this.f);
		FileOutputStream imagenSalida = new FileOutputStream(fsal);

		// Leemos y escribimos los primeros 54 bytes (información de la imagen)

		byte[] buffer = new byte[54];
		imagen.read(buffer);
		imagenSalida.write(buffer);

		// Ahora leemos de 3 en 3 bytes (píxel RGB)
		int R = imagen.read();
		int G = imagen.read();
		int B = imagen.read();

		while (B != -1) {
			int media = (R + G + B) / 3;
			imagenSalida.write(media);
			imagenSalida.write(media);
			imagenSalida.write(media);
			R = imagen.read();
			G = imagen.read();
			B = imagen.read();
		}

		imagen.close();
		imagenSalida.close();
	}

	private String getNombreSinExtension() {
		
		return  f.getName().split("\\.")[0];
	}
}
