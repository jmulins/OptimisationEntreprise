import org.knowm.xchart.*;
import org.knowm.xchart.style.OHLCStyler;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame{
    public ArrayList<JLabel> labels = new ArrayList<JLabel>();
    public ArrayList<JTextField> fields = new ArrayList<JTextField>();
    public OHLCChart chart = new OHLCChartBuilder().width(1280).height(720).title("Area Chart").xAxisTitle("X").yAxisTitle("Y").build();
    public static JPanel menuPanel = new JPanel();
    public static JPanel statisticsPanel = new JPanel();
    public static JPanel machineManagerPanel = new JPanel();




    public Window(){
        chart.getStyler().setDefaultSeriesRenderStyle(OHLCSeries.OHLCSeriesRenderStyle.HiLo);

        this.InitMenu();
        this.InitFrame();
    }
    public void InitFrame(){
        this.setTitle("Progiciel");
        this.setSize(Main.FRAME_SIZE);
        //this.setLayout(new GridLayout(5,2));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0,0,0));
        this.repaint();
        this.setVisible(true);

    }
    public void InitMenu(){
        // panel principal
        this.setLayout(new GridLayout(1,2));
        // panel des options
        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(0,0,0));
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // label en haut
        JLabel entreprise = new JLabel("GPAO CCBY Raziout");
        entreprise.setForeground(new Color(255,255,255));
        entreprise.setFont(new Font("Roboto", Font.ITALIC, 15));
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10,10,0,0);
        menuPanel.add(entreprise, gbc);

        // titre
        JLabel title = new JLabel("Progiciel de gestion des stocks");
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Roboto", Font.BOLD, 30));
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx=1;
        gbc.insets = new Insets(10,10,0,0);
        JPanel menus = new JPanel();
        menus.setBackground(new Color(0,0,0));
        menus.setLayout(new GridLayout(Main.BUTTON_LABELS.length+1,1,0,20));
        menus.add(title);
        for(JButton menu : Main.MENUS_BUTTONS){
            switch (menu.getText()){
                case "Statistiques entreprise":
                    menu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            deleteMenu();
                            InitStatisticsMenu();
                        }
                    });
                    break;
                case "Ajouter/Supprimer machine":
                    menu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                    break;

            }

            menus.add(menu);
        }
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx=0;
        gbc.gridy=0;
        menuPanel.add(menus,gbc);
        chart.addSeries("normal", Utils.generateXForList(Main.listePlastique), Main.listePlastique);
        chart.addSeries("momentum", Utils.generateXForList(Main.momentumList), Main.momentumList);
        chart.addSeries("TCI", Utils.generateXForList(Main.tciList), Main.tciList);
        /*JPanel chartPanel = new XChartPanel<OHLCChart>(chart);
        chartPanel.setBackground(new Color(0,0,0));
        this.add(chartPanel);
         */

        // Statistiques de l'entreprise
        JPanel statistiques = new JPanel();
        statistiques.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        this.add(menuPanel);


    }
    public void deleteMenu(){
        for(Component c : menuPanel.getComponents()){
            if(c instanceof JLabel || c instanceof JPanel){
                menuPanel.remove(c);
            }
        }
        menuPanel.repaint();
    }
    public void InitStatisticsMenu(){
        statisticsPanel.setBackground(new Color(0,0,0));
        statisticsPanel.setLayout(new GridBagLayout());
        JLabel titre = new JLabel("Statistiques");
        titre.setForeground(new Color(255,255,255));
        titre.setFont(new Font("Roboto", Font.BOLD, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        statisticsPanel.add(titre, gbc);
        this.menuPanel.add(statisticsPanel);
        SwingUtilities.updateComponentTreeUI(this);


    }
}
