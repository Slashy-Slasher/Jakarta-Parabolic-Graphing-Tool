import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.JFreeChartEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Model
{
    //private View view = new View();
    private String csvPathname = "C:\\Users\\aardv\\eclipse-jee-workplace\\WebAppExample\\src\\main\\webapp\\userCsv.csv";
    private String pngPathname = "C:\\Users\\aardv\\eclipse-jee-workplace\\WebAppExample\\src\\main\\webapp\\userPNG.png";

    public void createFile()
    {
        try
        {
            File myObj = new File(csvPathname);
            
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
    
    public void createPng() throws FileNotFoundException
    {
    	//Creates PNG
        Scanner sc;
    	try
        {
            File myObj = new File(pngPathname);
            

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    	
    	/*
    	try
        {
            sc = new Scanner(new File(csvPathname));
            sc.useDelimiter(","); //sets the delimiter pattern
            String[] csvhol;
            while (sc.hasNext())  //returns a boolean value
            {
                csvhol = sc.nextLine().split(",");

                for(int i = 0; i<csvhol.length; i++)
                {
                    System.out.print(csvhol[i] + " ");
                }
                System.out.println("");
            }
            sc.close();
            System.out.println("File opened");
        }
        catch (FileNotFoundException e) {
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	
    	 XYSeries series = new XYSeries("My Series");
         int x = -50;
         int y = 50;
         for(int i = x-1; i<y; i++)
         {
             //System.out.println(i + ": " + (Math.pow(i, 2)+i*2+1));
             series.add(i, (Math.pow(i, 2)+i*2+1));
             //dataset.addValue(i, pngPathname, csvPathname);


         }
         */
       
         
         //XYSeriesCollection dataset = new XYSeriesCollection();
         //DefaultCategoryDataset dataset = series;
         //dataset.addValue(y, pngPathname, csvPathname);
         //dataset.
         //dataset.addSeries(series);
         //dataset

         // create the chart
         /*
         JFreeChart chart = ChartFactory.createXYLineChart(
                 "My XY Chart", // chart title
                 "X", // x axis label
                 "Y", // y axis label
                 (XYDataset)series, // data
                 PlotOrientation.VERTICAL,
                 true, // include legend
                 true, // tooltips
                 false // urls
         );
         */
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         String csvFile = "data.csv";
         String line = "";
         String cvsSplitBy = ",";

         
         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
             while ((line = br.readLine()) != null) {
                 // use comma as separator
                 String[] data = line.split(cvsSplitBy);
                 // Assuming the CSV file has two columns, x and y
                 dataset.addValue(Double.parseDouble(data[1]), "Data", data[0]);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         
         
         
         JFreeChart chart = ChartFactory.createLineChart(
                 "CSV Data Graph", // chart title
                 "X", // x-axis label
                 "Y", // y-axis label
                 dataset
         );
         
         
         // display the chart in a frame
         ChartFrame frame = new ChartFrame("My XY Chart", chart);
         frame.pack();
         frame.setVisible(true);
		
         
         
         
         File file = new File("userChart.png");
         try
         {
             FileOutputStream fos = new FileOutputStream(file);

             ChartUtilities.writeChartAsPNG(fos,chart, frame.getWidth(), frame.getHeight());
         }
         catch (IOException e)
         {
             throw new RuntimeException(e);
         }
    }
    
    
    
    private Object createDataset() {
		// TODO Auto-generated method stub
		return null;
	}



	public void createCSV(String inputX, String inputZ)
    {
    	Scanner sc = new Scanner(System.in);
        try {
            FileWriter myWriter = new FileWriter(csvPathname);
            myWriter.write("x,y,"+"\n");
            double y = 0;

            for (int i = Integer.parseInt(inputX)-1; i < Integer.parseInt(inputZ); i++)
            {
                y = Math.pow(i, 2) + (2 * i) + 1;
                myWriter.write((i+1)+ "," + y + "\n");

            }
            myWriter.close();            
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try
        {
            sc = new Scanner(new File(csvPathname));
            sc.useDelimiter(","); //sets the delimiter pattern
            String[] csvhol;
            while (sc.hasNext())  //returns a boolean value
            {
                csvhol = sc.nextLine().split(",");

                for(int i = 0; i<csvhol.length; i++)
                {
                    System.out.print(csvhol[i] + " ");
                }
                System.out.println("");
            }
            sc.close();
            System.out.println("File opened");
        }
        catch (FileNotFoundException e) {
        }
    }
}
