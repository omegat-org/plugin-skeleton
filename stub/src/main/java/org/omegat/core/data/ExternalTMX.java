/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2010 Alex Buloichik
               2012 Thomas CORDONNIER
               2013 Aaron Madlon-Kay
               2014 Alex Buloichik
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
import java.util.List;


/**
 * Stub.
 * Class for store data from TMX from /tm/ folder. They are used only for fuzzy matches.
 * 
 * @author Alex Buloichik (alex73mail@gmail.com)
 * @author Thomas CORDONNIER
 * @author Aaron Madlon-Kay
 */
public class ExternalTMX {

    public ExternalTMX(final ProjectProperties props, final File file, final boolean extTmxLevel2,
            final boolean useSlash) throws Exception {
    }

    public String getName() {
        return null;
    }

    public List<PrepareTMXEntry> getEntries() {
        return null;
    }

    public static boolean isInPath(File path, File tmxFile) {
        return false;
    }
}
