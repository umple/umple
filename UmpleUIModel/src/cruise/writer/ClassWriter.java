package cruise.writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import cruise.exception.GeneratorException;

public class ClassWriter {

	public static void writeFile(String outputFolder, String packageName,
			String fileName, String content) throws IOException {
		String completePath = outputFolder + File.separator
				+ (packageName.replace('.', File.separatorChar));

		File file = new File(completePath);
		file.mkdirs();
		file = new File(completePath + File.separator + fileName);
		if (file.exists())
			file.delete();
		FileWriter fWriter = new FileWriter(file);
		try {
			System.out.println("Writing: "+file.getAbsolutePath());
			fWriter.write(content);
		} finally {
			fWriter.close();
		}
	}

	public static void clearFolder(File outputFolder,
			FilenameFilter filenameFilter) {
		if (outputFolder.exists()) {
			File[] files = outputFolder.listFiles(filenameFilter);
			for (int nFileCur = 0; nFileCur < files.length; nFileCur++) {
				File oFileCur = files[nFileCur];
				if (oFileCur.isDirectory()) {
					clearFolder(oFileCur, filenameFilter);
				}
				oFileCur.delete();
			}
		} else {

			outputFolder.mkdir();
		}
		if (!outputFolder.exists())
			throw new GeneratorException(
					"Error: Cannot create the output folder: "
							+ outputFolder.getAbsolutePath());
		if (outputFolder.listFiles(filenameFilter).length > 0)
			throw new GeneratorException(
					"Error: The output folder could not be cleaned");

	}

	public static void copyFile(File in, File out) throws IOException {
		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		System.out.println("Copying: "+in.getAbsolutePath());
		try {
			byte[] buffer = new byte[1024];
			int i = 0;
			while ((i = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, i);
			}
		} catch (IOException e) {
			throw new GeneratorException("Error: Copying the Umple file", e);

		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}

	public static void copyDirectory(File sourceLocation, File targetLocation) {
		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
				copyDirectory(new File(sourceLocation, children[i]), new File(
						targetLocation, children[i]));
			}
		} else {
			try {
				copyFile(sourceLocation, targetLocation);
			} catch (IOException e) {
				throw new GeneratorException(
						"Error: Copying the directory/file: "
								+ sourceLocation.getAbsolutePath(), e);
			}

		}
	}
}
