package org.bibsonomy.plugin.jabref.gui;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JToolBar;

import net.sf.jabref.gui.JabRefFrame;

import org.bibsonomy.plugin.jabref.BibSonomyGlobals;
import org.bibsonomy.plugin.jabref.BibSonomySidePaneComponent;
import org.bibsonomy.plugin.jabref.action.DeleteSelectedEntriesAction;
import org.bibsonomy.plugin.jabref.action.ExportSelectedEntriesAction;
import org.bibsonomy.plugin.jabref.action.ToggleSidePaneComponentAction;


/**
 * {@link BibSonomyToolBarExtender} add the service specific buttons to the tool bar
 *
 * @author Waldemar Biller <biller@cs.uni-kassel.de>
 */
public class BibSonomyToolBarExtender {

    public static void extend(JabRefFrame jabRefFrame, BibSonomySidePaneComponent sidePaneComponent) {

        for (Component rp : jabRefFrame.getComponents()) {

            if (rp instanceof JRootPane) {

                for (Component lp : ((JRootPane) rp).getComponents()) {

                    if (lp instanceof JLayeredPane) {

                        for (Component p : ((JLayeredPane) lp).getComponents()) {

                            if (p instanceof JPanel) {

                                for (Component tb : ((JPanel) p).getComponents()) {

                                    if (tb instanceof JToolBar) {

                                        JToolBar toolBar = (JToolBar) tb;

                                        JButton searchEntries = new JButton(new ToggleSidePaneComponentAction(sidePaneComponent));
                                        searchEntries.setText(BibSonomyGlobals.BIBSONOMY_NAME);
                                        toolBar.add(searchEntries, 5);

                                        JButton exportEntries = new JButton(new ExportSelectedEntriesAction(jabRefFrame));
                                        exportEntries.setText(null);
                                        toolBar.add(exportEntries, 6);

                                        JButton deleteEntries = new JButton(new DeleteSelectedEntriesAction(jabRefFrame));
                                        deleteEntries.setText(null);
                                        toolBar.add(deleteEntries, 7);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}