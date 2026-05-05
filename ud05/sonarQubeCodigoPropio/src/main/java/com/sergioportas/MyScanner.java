package com.sergioportas;

class MyScanner {

    MyScanner(String cadena) {
        setCadenaEnviada(cadena);
    }

    private String cadenaEnviada = "";

    public String getCadenaEnviada() {
        return cadenaEnviada;
    }

    public void setCadenaEnviada(String cadenaEnviada) {
        this.cadenaEnviada = cadenaEnviada;
    }

    private String CadenaMostrar = "";

    public String getCadenaMostrar() {
        return CadenaMostrar;
    }

    public void setCadenaMostrar(String cadenaMostrar) {
        CadenaMostrar = cadenaMostrar;
    }

    private String CadenaAnalizada = "";

    public String getCadenaAnalizada() {
        return CadenaAnalizada;
    }

    public void setCadenaAnalizada(String cadenaAnalizada) {
        StringBuilder devolver = new StringBuilder(getCadenaAnalizada());
        devolver.append(cadenaAnalizada);
        CadenaAnalizada = devolver.toString();
    }

    private int Pos = 0;

    public int getPos() {
        int posiciones = 0;
        for (int c = 0; c < getCadenaAnalizada().length(); c += 1) {
            posiciones++;
        }
        return posiciones;
    }

    Boolean hasNextLine() {
        if (getCadenaEnviada().equals(getCadenaAnalizada())) return false;
        return true;
    }

    String nextLine() {
        StringBuilder cadenaAnalizada = new StringBuilder("");
        StringBuilder cadenaEnviada = new StringBuilder("");
        String pediente = getCadenaEnviada().replace(getCadenaAnalizada(), "");
        char[] trabajamosCon = pediente.toCharArray();
        Boolean estado = false;
        for (int c = 0; c < trabajamosCon.length; c += 1) {
            if (trabajamosCon[c] == '\n' && !estado) {
                cadenaAnalizada.append(trabajamosCon[c]);
                cadenaEnviada.append(trabajamosCon[c]);
                continue;
            }
            if (trabajamosCon[c] != '\n' && !estado) {
                cadenaAnalizada.append(trabajamosCon[c]);
                cadenaEnviada.append(trabajamosCon[c]);
                estado = true;
                continue;
            }
            if (estado) {
                if (trabajamosCon[c] == '\n') {
                    cadenaAnalizada.append(trabajamosCon[c]);
                    break;
                }
                cadenaAnalizada.append(trabajamosCon[c]);
                cadenaEnviada.append(trabajamosCon[c]);
            }
        }
        setCadenaMostrar(cadenaEnviada.toString());
        setCadenaAnalizada(cadenaAnalizada.toString());
        getPos();
        return getCadenaMostrar();
    }

    Boolean hasNext() {
        String CadenaRestante = getCadenaEnviada().replace(getCadenaAnalizada(), "");
        for (int c = 0; c < CadenaRestante.length(); c += 1) {
            if (!(Character.isWhitespace(CadenaRestante.charAt(c)))) {
                return true;
            }
        }
        return false;
    }

    String next() {
        StringBuilder cadenaAnalizada = new StringBuilder("");
        StringBuilder cadenaEnviada = new StringBuilder("");
        String pediente = getCadenaEnviada().replace(getCadenaAnalizada(), "");
        char[] trabajamosCon = pediente.toCharArray();
        Boolean estado = false;
        for (int c = 0; c < trabajamosCon.length; c += 1) {
            if (Character.isWhitespace(trabajamosCon[c]) && !estado) {
                cadenaAnalizada.append(trabajamosCon[c]);
                continue;
            }
            if (!(Character.isWhitespace(trabajamosCon[c])) && !estado) {
                estado = true;
                cadenaAnalizada.append(trabajamosCon[c]);
                cadenaEnviada.append(trabajamosCon[c]);
                continue;
            }

            if (estado) {
                if (Character.isWhitespace(trabajamosCon[c])) {
                    break;
                }
                cadenaAnalizada.append(trabajamosCon[c]);
                cadenaEnviada.append(trabajamosCon[c]);
            }
        }
        setCadenaMostrar(cadenaEnviada.toString());
        setCadenaAnalizada(cadenaAnalizada.toString());
        getPos();
        return getCadenaMostrar();
    }

    Integer nextInt() {
        StringBuilder cadenaAnalizada = new StringBuilder("");
        StringBuilder cadenaEnviada = new StringBuilder("");
        String pediente = getCadenaEnviada().replace(getCadenaAnalizada(), "");
        char[] trabajamosCon = pediente.toCharArray();
        Boolean estado = false;
        for (int c = 0; c < trabajamosCon.length; c += 1) {
            if (Character.isWhitespace(trabajamosCon[c]) && !estado) {
                cadenaAnalizada.append(trabajamosCon[c]);
                continue;
            }
            if (!(Character.isWhitespace(trabajamosCon[c])) && !estado) {
                estado = true;
                cadenaAnalizada.append(trabajamosCon[c]);
                cadenaEnviada.append(trabajamosCon[c]);
                continue;
            }

            if (estado) {
                if (Character.isWhitespace(trabajamosCon[c])) {
                    break;
                }
                cadenaAnalizada.append(trabajamosCon[c]);
                cadenaEnviada.append(trabajamosCon[c]);
            }
        }
        setCadenaMostrar(cadenaEnviada.toString());
        setCadenaAnalizada(cadenaAnalizada.toString());
        getPos();
        int pasamos = Integer.parseInt(getCadenaMostrar());
        return pasamos;
    }
}
