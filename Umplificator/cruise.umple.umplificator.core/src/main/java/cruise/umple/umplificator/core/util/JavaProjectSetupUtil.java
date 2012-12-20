package cruise.umple.umplificator.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xtext.ui.junit.util.PluginUtil;

import com.google.common.collect.Lists;

@SuppressWarnings("restriction")
public class JavaProjectSetupUtil {
	
	public static final String NATURE_ID = "org.eclipse.jdt.core.javanature"; 
	
	public static IJavaProject createJavaProject(String projectName) throws CoreException {
		IProject project = createSimpleProject(projectName);
		JavaCore.initializeAfterLoad(monitor());
		IJavaProject javaProject = makeJavaProject(project);
		return javaProject;
	}

	public static IProject createSimpleProject(String projectName) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		deleteProject(project);
		project.create(null);
		project.open(null);
		return project;
	}

	public static IFolder createExternalFolder(String folderName) throws CoreException {
		IPath externalFolderPath = new Path(folderName);
		IProject externalFoldersProject = JavaModelManager.getExternalManager().getExternalFoldersProject();
		if (!externalFoldersProject.isAccessible()) {
			if (!externalFoldersProject.exists())
				externalFoldersProject.create(monitor());
			externalFoldersProject.open(monitor());
		}
		IFolder result = externalFoldersProject.getFolder(externalFolderPath);
		result.create(true, false, null);
//		JavaModelManager.getExternalManager().addFolder(result.getFullPath());
		return result;
	}

	public static void deleteExternalFolder(IFolder folder) throws CoreException {
		JavaModelManager.getExternalManager().removeFolder(folder.getFullPath());
		folder.delete(true, null);
	}

	public static IFolder deleteSourceFolder(IJavaProject project, String folderPath) throws JavaModelException,
			CoreException {
		IFolder folder = project.getProject().getFolder(folderPath);
		deleteClasspathEntry(project, folder.getFullPath());
		folder.delete(true, monitor());
		return folder;
	}

	public static void addProjectReference(IJavaProject from, IJavaProject to) throws CoreException {
		addToClasspath(from, JavaCore.newProjectEntry(to.getPath()));
	}

	public static void removeProjectReference(IJavaProject from, IJavaProject to) throws CoreException {
		List<IClasspathEntry> classpath = Lists.newArrayList(from.getRawClasspath());
		Iterator<IClasspathEntry> iterator = classpath.iterator();
		while (iterator.hasNext()) {
			IClasspathEntry entry = iterator.next();
			if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
				if (entry.getPath().equals(to.getPath()))
					iterator.remove();
			}
		}
		from.setRawClasspath(classpath.toArray(new IClasspathEntry[classpath.size()]), monitor());
	}

	public static void deleteJavaProject(IJavaProject javaProject) throws CoreException {
		IProject project = javaProject.getProject();
		deleteProject(project);
	}

	public static void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			if (project.isOpen()) {
				project.close(null);
			}
			project.delete(true, true, null);
		}
	}

	public static IJavaProject makeJavaProject(IProject project) throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.save(null, true);
		addProjectNature(project, JavaCore.NATURE_ID);
		addSourceFolder(javaProject, "src");
		addJreClasspathEntry(javaProject);
		return javaProject;
	}

	public static void addProjectNature(IProject project, String natureId) throws CoreException {
		IProjectNature existingNature = project.getNature(natureId);
		if (existingNature == null) {
			IProjectDescription projectDescription = project.getDescription();
			String[] natureIds = projectDescription.getNatureIds();
			String[] newNatureIds = new String[natureIds.length + 1];
			System.arraycopy(natureIds, 0, newNatureIds, 0, natureIds.length);
			newNatureIds[natureIds.length] = natureId;
			projectDescription.setNatureIds(newNatureIds);
			project.setDescription(projectDescription, null);
		}
	}

	public static IFolder addSourceFolder(IJavaProject javaProject, String folderName) throws CoreException,
			JavaModelException {
		IProject project = javaProject.getProject();
		IPath projectPath = project.getFullPath();

		deleteClasspathEntry(javaProject, projectPath);

		IFolder srcFolder = createSubFolder(project, folderName); //$NON-NLS-1$
		IClasspathEntry srcFolderClasspathEntry = JavaCore.newSourceEntry(srcFolder.getFullPath());
		addToClasspath(javaProject, srcFolderClasspathEntry);
		return srcFolder;
	}

	public static void deleteClasspathEntry(IJavaProject javaProject, IPath path) throws JavaModelException {
		IClasspathEntry[] classpath = javaProject.getRawClasspath();
		for (int i = 0; i < classpath.length; ++i) {
			IPath entryPath = classpath[i].getPath();
			if (path.equals(entryPath)) {
				IClasspathEntry[] newClasspath = new IClasspathEntry[classpath.length - 1];
				System.arraycopy(classpath, 0, newClasspath, 0, i);
				System.arraycopy(classpath, i + 1, newClasspath, i, classpath.length - i - 1);
				javaProject.setRawClasspath(newClasspath, null);

			}
		}
	}

	public static void addToClasspath(IJavaProject javaProject, IClasspathEntry newClassPathEntry)
			throws JavaModelException {
		IClasspathEntry[] newClassPath;
		IClasspathEntry[] classPath = javaProject.getRawClasspath();
		for (IClasspathEntry classPathEntry : classPath) {
			if (classPathEntry.equals(newClassPathEntry)) {
				return;
			}
		}
		newClassPath = new IClasspathEntry[classPath.length + 1];
		System.arraycopy(classPath, 0, newClassPath, 1, classPath.length);
		newClassPath[0] = newClassPathEntry;
		javaProject.setRawClasspath(newClassPath, null);
		waitForAutoBuild();
	}

	public static IFolder createSubFolder(IProject project, String folderName) throws CoreException {
		IFolder folder = project.getFolder(folderName);
		if (folder.exists()) {
			folder.delete(true, null);
		}
		folder.create(true, true, null);
		return folder;
	}

	private static void addJreClasspathEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry existingJreContainerClasspathEntry = getJreContainerClasspathEntry(javaProject);
		if (existingJreContainerClasspathEntry == null) {
			IClasspathEntry defaultJREContainerEntry = JavaRuntime.getDefaultJREContainerEntry();
			addToClasspath(javaProject, defaultJREContainerEntry);
		}
	}

	public static IClasspathEntry getJreContainerClasspathEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
		for (IClasspathEntry classpathEntry : rawClasspath) {
			int entryKind = classpathEntry.getEntryKind();
			if (entryKind == IClasspathEntry.CPE_CONTAINER) {
				IPath path = classpathEntry.getPath();
				String pathAsString = path.toString();
				if (pathAsString.startsWith(JavaRuntime.JRE_CONTAINER)) {
					return classpathEntry;
				}
			}
		}
		return null;
	}

	public static IClasspathEntry addPlatformJarToClasspath(final Plugin srcPlugin, final String jarFileName,
			final IJavaProject destProject) throws JavaModelException, IOException {
		final IPath jarFilePath = PluginUtil.findPathInPlugin(srcPlugin, jarFileName);
		final IClasspathEntry newLibraryEntry = JavaCore.newLibraryEntry(jarFilePath, null, null);
		addToClasspath(destProject, newLibraryEntry);
		return newLibraryEntry;
	}

	public static IClasspathEntry addJarToClasspath(IJavaProject javaProject, IFile jarFile) throws JavaModelException {
		IClasspathEntry newLibraryEntry = JavaCore.newLibraryEntry(jarFile.getFullPath(), null, null);
		addToClasspath(javaProject, newLibraryEntry);
		return newLibraryEntry;
	}

	public static IClasspathEntry addExternalFolderToClasspath(IJavaProject javaProject, IFolder folder)
			throws JavaModelException {
		IClasspathEntry newLibraryEntry = JavaCore.newLibraryEntry(folder.getFullPath(), null, null);
		addToClasspath(javaProject, newLibraryEntry);
		return newLibraryEntry;
	}

	public static File createExternalJar(InputStream data, String nameWithoutJarSuffix) throws IOException,
			FileNotFoundException {
		File tempFile = File.createTempFile(nameWithoutJarSuffix, ".jar");
		tempFile.createNewFile();
		FileOutputStream stream = new FileOutputStream(tempFile);
		int i = -1;
		while ((i = data.read()) != -1)
			stream.write(i);
		stream.close();
		data.close();
		return tempFile;
	}
	
	public static IProgressMonitor monitor() {
		return new NullProgressMonitor();
	}
	
	public static void waitForAutoBuild() {
		boolean wasInterrupted = false;
		do {
			try {
				Job.getJobManager().join(ResourcesPlugin.FAMILY_AUTO_BUILD,
						null);
				wasInterrupted = false;
			} catch (OperationCanceledException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				wasInterrupted = true;
			}
		} while (wasInterrupted);
	}

}
