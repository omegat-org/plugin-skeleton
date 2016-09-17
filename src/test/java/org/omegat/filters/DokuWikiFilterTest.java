/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2008 Alex Buloichik
               2010 Volker Berlin
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

package org.omegat.filters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.omegat.filters2.text.dokuwiki.DokuWikiFilter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DokuWikiFilterTest extends TestFilterBase {

    @Test
    public void testTextFilterParsing() throws Exception {
        List<String> expected = new ArrayList<>();
        expected.add("Header");
        expected.add("This is a flow text.");
        expected.add("multiple spaces in text");
        expected.add("* asterisk * asterisk");
        expected.add("list item");
        expected.add("- minus - minus");
        expected.add("numeric item");
        expected.add("before code");
        expected.add("mid code");
        expected.add("after code");
        expected.add("<del>deleted</del>");
        expected.add("header");
        expected.add("cell1");
        expected.add("cell2");
        expected.add("cell3 {{..:images:f_n_16.png|Number}}");
        List<String> entries = parse(new DokuWikiFilter(), "/dokuwiki.txt");
        assertEquals(entries, expected);
    }

    @Test
    public void testTranslate() throws Exception {
        translateText(new DokuWikiFilter(), "/dokuwiki-translate.txt");
    }

    @Test
    public void testIsFileSupported() {
        DokuWikiFilter filter = new DokuWikiFilter();
        assertTrue(filter.isFileSupported(new File(this.getClass().getResource("/dokuwiki.txt").getFile()),
                new TreeMap<>(), context));
        assertFalse(filter.isFileSupported(new File(this.getClass().getResource("/text1.txt").getFile()),
                new TreeMap<>(), context));
    }

    @Test
    public void testLoad() throws Exception {
        test(new DokuWikiFilter(), "dokuwiki");
    }
}