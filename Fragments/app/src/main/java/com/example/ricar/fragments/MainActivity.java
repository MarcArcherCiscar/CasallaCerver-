package com.example.ricar.fragments;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements FragmentTitulaciones.OnFragmentInteractionListener, FragmentCicles.OnFragmentInteractionListener, FragmentLlistat.OnFragmentInteractionListener{
    private FragmentTitulaciones fragmentTitulaciones;
    ArrayList<CicleFlorida> envairArray;
    private   ArrayList<CicleFlorida> llistat_titulacions ;

    int x=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llistat_titulacions = new ArrayList<CicleFlorida>();
        ompliTitulacions();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void ompliTitulacions(){
        CicleFlorida c;


        c = new CicleFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        llistat_titulacions.add(c);
    }


    @Override
    public void mostrarCiclesEmpresa() {

        boolean mitja=false;
        boolean sup=false;
        //Tornar un ArrayList<CicleFlorida> llistatFiltrat = buscaCiclesXFaminiliaProfessional("EMPRESA");
        ArrayList<CicleFlorida> empresas = new ArrayList<>();
        String Empresa="EMPRESA";
        Iterator it = llistat_titulacions.iterator();
        while (it.hasNext()) {
            CicleFlorida cl= (CicleFlorida) it.next();
            if(cl.getFamiliaProfessional().equalsIgnoreCase(Empresa)) {
                empresas.add(cl);
            }
        }

        // Tornar tipus de nivells
        Iterator it2=empresas.iterator();
        while (it2.hasNext()){
            CicleFlorida cl= (CicleFlorida) it2.next();
            if (cl.getTipus().equalsIgnoreCase("Mitjà")){
                mitja=true;
            }
            if (cl.getTipus().equalsIgnoreCase("Superior")){
                sup=true;
            }
        }
        if (mitja && sup){
            x=2;
        }else if (sup){
            x=1;
        }else {
            x=0;
        }





        //Crear fragmentCicles, passant-li parametres
        Fragment FragmentChicles=FragmentCicles.newInstance(envairArray,x);
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.chicles,FragmentChicles);
        ft.commit();
    }

    @Override
    public void mostrarCiclesEsports() {

        boolean mitja=false;
        boolean sup=false;
        //Tornar un ArrayList<CicleFlorida> llistatFiltrat = buscaCiclesXFaminiliaProfessional("EMPRESA");
        ArrayList<CicleFlorida> esports = new ArrayList<>();
        String esportsString="ESPORT";
        Iterator it = llistat_titulacions.iterator();
        while (it.hasNext()) {
            CicleFlorida cl= (CicleFlorida) it.next();
            if(cl.getFamiliaProfessional().equalsIgnoreCase(esportsString)) {
                esports.add(cl);
            }
        }

        // Tornar tipus de nivells
        Iterator it2=esports.iterator();
        while (it2.hasNext()){
            CicleFlorida cl= (CicleFlorida) it2.next();
            if (cl.getTipus().equalsIgnoreCase("Mitjà")){
                mitja=true;
            }
            if (cl.getTipus().equalsIgnoreCase("Superior")){
                sup=true;
            }
        }
        if (mitja && sup){
            x=2;
        }else if (sup){
            x=1;
        }else {
            x=0;
        }





        //Crear fragmentCicles, passant-li parametres
        Fragment FragmentChicles=FragmentCicles.newInstance(envairArray,x);
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.chicles,FragmentChicles);
        ft.commit();

    }

    @Override
    public void mostrarCiclesInformatica() {
        boolean mitja=false;
        boolean sup=false;
        //Tornar un ArrayList<CicleFlorida> llistatFiltrat = buscaCiclesXFaminiliaProfessional("EMPRESA");
        ArrayList<CicleFlorida> informatica = new ArrayList<>();
        String informaticaString="INFORMÀTICA";
        Iterator it = llistat_titulacions.iterator();
        while (it.hasNext()) {
            CicleFlorida cl= (CicleFlorida) it.next();
            if(cl.getFamiliaProfessional().equalsIgnoreCase(informaticaString)) {
                informatica.add(cl);
            }
        }

        // Tornar tipus de nivells
        Iterator it2=informatica.iterator();
        while (it2.hasNext()){
            CicleFlorida cl= (CicleFlorida) it2.next();
            if (cl.getTipus().equalsIgnoreCase("Mitjà")){
                mitja=true;
            }
            if (cl.getTipus().equalsIgnoreCase("Superior")){
                sup=true;
            }
        }
        if (mitja && sup){
            x=2;
        }else if (sup){
            x=1;
        }else {
            x=0;
        }

//Crear fragmentCicles, passant-li parametres
        Fragment FragmentChicles=FragmentCicles.newInstance(envairArray,x);
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.chicles,FragmentChicles);
        ft.commit();

    }
}
