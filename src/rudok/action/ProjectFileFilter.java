package rudok.action;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Locale;

public class ProjectFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().toLowerCase().endsWith(".gpf"));
    }

    @Override
    public String getDescription() {
        return "GrafEditor Projct Files (*.gpf)";
    }
}
