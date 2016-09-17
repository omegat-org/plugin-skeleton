/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2012 Alex Buloichik
               2013-2014 Aaron Madlon-Kay, Alex Buloichik
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/
package org.omegat.core.data;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.omegat.util.Language;

/**
 * Stub.
 * Class for store data from project_save.tmx.
 * 
 * Orphaned or non-orphaned translation calculated by RealProject.
 * 
 * @author Alex Buloichik (alex73mail@gmail.com)
 * @author Aaron Madlon-Kay
 */
public class ProjectTMX {

    /**
     * Storage for default translations for current project.
     * 
     * It must be used with synchronization around ProjectTMX.
     */
    Map<String, TMXEntry> defaults;

    /**
     * Storage for alternative translations for current project.
     * 
     * It must be used with synchronization around ProjectTMX.
     */
    Map<EntryKey, TMXEntry> alternatives;
    
    final CheckOrphanedCallback checkOrphanedCallback;

    public ProjectTMX(Language sourceLanguage, Language targetLanguage, boolean isSentenceSegmentingEnabled,
                      File file, CheckOrphanedCallback callback) throws Exception {
        this();
    }

    public ProjectTMX() {
        checkOrphanedCallback = new CheckOrphanedCallback() {
            @Override
            public boolean existEntryInProject(EntryKey key) {
                return false;
            }

            @Override
            public boolean existSourceInProject(String src) {
                return false;
            }
        };
    }

    /**
     * Check TMX for empty.
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * It saves current translation into file.
     */
    public void save(ProjectProperties props, String translationFile, boolean translationUpdatedByUser)
            throws Exception {
    }

    public void exportTMX(ProjectProperties props, File outFile, final boolean forceValidTMX,
            final boolean levelTwo, final boolean useOrphaned) throws Exception {

    }

    /**
     * Get default translation or null if not exist.
     */
    public TMXEntry getDefaultTranslation(String source) {
        synchronized (this) {
            return defaults.get(source);
        }
    }

    /**
     * Get multiple translation or null if not exist.
     */
    public TMXEntry getMultipleTranslation(EntryKey ek) {
        synchronized (this) {
            return alternatives.get(ek);
        }
    }

    /**
     * Set new translation.
     */
    public void setTranslation(SourceTextEntry ste, TMXEntry te, boolean isDefault) {
    }

    /**
     * Returns the collection of TMX entries that have a default translation
     */
    public Collection<TMXEntry> getDefaults() {
        return defaults.values();
    }
    /**
     * Returns the collection of TMX entries that have an alternative translation
     * @return
     */
    public Collection<TMXEntry> getAlternatives() {
        return alternatives.values();
    }

    public interface CheckOrphanedCallback {
        boolean existEntryInProject(EntryKey key);

        boolean existSourceInProject(String src);
    }

    public void replaceContent(ProjectTMX tmx) {
    }

    @Override
    public String toString() {
        return "";
    }
}
