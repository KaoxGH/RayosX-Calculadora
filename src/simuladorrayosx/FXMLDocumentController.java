/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorrayosx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static java.lang.Math.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Jorge
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btn1;
    
    @FXML
    private Button btn2;
    
    @FXML
    private Button btn3;
    
    @FXML
    private Button btnVolver;
    
    @FXML
    public Button btnCerrar, btnCalcular, btnLimpiar, btnFormulas, btnVolverASIM, btnProblema1, btnProblema2;
    
    @FXML
    public Button botonResolver1, btnResolver2;
    
    @FXML 
    public TextField Dato1, Dato2, DatoTheta, respuesta1, respuesta2, respuesta3, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15 ;
    
    @FXML
    public StackPane stackPane;
            
    @FXML
    public TextField li, lf, theta, ei, ef, pi, pf, gi, gf, phi, k;
    
     @FXML
 public void handleButtonAction(ActionEvent event) throws IOException{
     Stage stage; 
     Parent root;
     if(event.getSource()==btn1){
        //get reference to the button's stage         
        stage=(Stage) btn1.getScene().getWindow();
        //load up OTHER FXML document
  root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
      }
     else if(event.getSource()==btn2){
       stage=(Stage) btn2.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("FXMLinformacion.fxml"));
      }
     else if(event.getSource()==btn3){
       stage=(Stage) btn3.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("FXMLequipo.fxml"));
     }
     else if(event.getSource()==btnFormulas){
       stage=(Stage) btnFormulas.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("FXMLFormulas.fxml"));
     }
     else if(event.getSource()==btnVolverASIM){
       stage=(Stage) btnVolverASIM.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
     }
     else if(event.getSource()==btnProblema1){
       stage=(Stage) btnProblema1.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("FXMLProblema1.fxml"));
     }
     else if(event.getSource()==btnProblema2){
       stage=(Stage) btnProblema2.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("FXMLProblema2.fxml"));
     }
     else{
         stage=(Stage) btnVolver.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
     }
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
    
 @FXML
public void handleCloseButtonAction(ActionEvent event) {
    Stage stage = (Stage) btnCerrar.getScene().getWindow();
    stage.close();
}

        @FXML 
        public void Calculo (ActionEvent event){
        String lic = li.getText();
        String thetac = theta.getText();
        try{
        double lambdai = Double.parseDouble(lic);
        double thetacd = Double.parseDouble(thetac);
        double lambdaf = (0.024e-10*(1-cos(toRadians(thetacd)))+lambdai);
        double c = (3e8); //constante de multiplicar h*c
        double h = (6.626e-34);//constante h
        double eicd = (h*c/lambdai);
        double efcd = (h*c/lambdaf);
        double picd = (h/lambdai);
        double pfcd = (h/lambdaf);
        double kcd = (eicd-efcd);
        double gicd = (c/lambdai);
        double gfcd = (c/lambdaf);
        double a = (lambdai*sin(toRadians(thetacd)));
        double s = (lambdaf-(lambdai*cos(toRadians(thetacd))));
        double phicd = toDegrees(atan(a/s));
        String eic = String.valueOf(eicd);
        String efc = String.valueOf(efcd);
        String pic = String.valueOf(picd);
        String pfc = String.valueOf(pfcd);
        String kc = String.valueOf(kcd);
        String gic = String.valueOf(gicd);
        String gfc = String.valueOf(gfcd);
        String phic = String.valueOf(phicd);
        String lfc = String.valueOf(lambdaf);
        ei.setText(eic);
        ef.setText(efc);
        pi.setText(pic);
        pf.setText(pfc);
        k.setText(kc);
        gi.setText(gic);
        gf.setText(gfc);
        phi.setText(phic);
        lf.setText(lfc);
        }
        catch(NumberFormatException e)    //si no, mostrar:
        {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Simulador de Rayos X");
        alert.setHeaderText(null);
        alert.setContentText("Introduce variables que sean válidas.");

        alert.showAndWait();
        }
        ei.setEditable(false);
        ef.setEditable(false);
        pi.setEditable(false);
        pf.setEditable(false);
        k.setEditable(false);
        gi.setEditable(false);
        gf.setEditable(false);
        phi.setEditable(false);
        lf.setEditable(false);
        }
        
   public void Limpiar(ActionEvent event) {
     li.setText("");
     lf.setText("");
     theta.setText("");
     ei.setText("");
     ef.setText("");
     pi.setText("");
     pf.setText("");
     k.setText("");
     gi.setText("");
     gf.setText("");
     phi.setText("");
}
 
   public void Resolver1 (ActionEvent e){
        double lambdai = Double.parseDouble(Dato1.getText());
        double theta = Double.parseDouble(Dato2.getText());
        double c = (3e8); //velocidad de la luz
        double h = (6.626e-34);//constante h
        double r1 = 0.024e-10*(1-cos(toRadians(theta)))+lambdai;
        double r2 = ((h*c)/lambdai)-((h*c)/r1);
        double r3 = (h/lambdai);
        respuesta1.setText(String.valueOf(r1));
        respuesta2.setText(String.valueOf(r2));
        respuesta3.setText(String.valueOf(r3));
        l1.setText(String.valueOf(theta));
        l2.setText(String.valueOf(lambdai));
        l4.setText(String.valueOf(lambdai));
        l6.setText(String.valueOf(lambdai));
        l8.setText(String.valueOf(lambdai));
        l5.setText(String.valueOf(r1));
        l7.setText(String.valueOf(r1));
   }
   
      public void Resolver2 (ActionEvent e){
        double theta = Double.parseDouble(DatoTheta.getText());
        double c = (3e8); //velocidad de la luz
        double h = (6.626e-34);//constante h
        double r1 = (0.024e-10*(1-cos(toRadians(theta))))/2;//lambda inicial
        double r2 = (3*r1); //lambda final
        double r3 = ((h*c)/r1); //energia inicial
        double r4 = (r3)/3;//energía final
        double r5 = toDegrees((r1*cos(toRadians(theta)))/(r2-r1*cos(toRadians(theta))));
        l3.setText(String.valueOf(r1));
        l5.setText(String.valueOf(r2));
        l7.setText(String.valueOf(r3));
        l9.setText(String.valueOf(r4));
        l15.setText(String.valueOf(r5));//respuestas
        l1.setText(String.valueOf(theta));
        l2.setText(String.valueOf(theta));
        l11.setText(String.valueOf(theta));
        l14.setText(String.valueOf(theta));//theta
        l8.setText(String.valueOf(r3));
        l4.setText(String.valueOf(r1));
        l6.setText(String.valueOf(r1));
        l10.setText(String.valueOf(r1));
        l13.setText(String.valueOf(r1));//lambdas iniciales
        l12.setText(String.valueOf(r2));//lambdas finales
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
