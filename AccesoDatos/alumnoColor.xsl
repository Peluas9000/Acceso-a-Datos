<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <!-- Salida en formato HTML -->
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <!-- Plantilla principal -->
  <xsl:template match="/Alumnos">
    <html>
      <head>
        <meta charset="utf-8"/>
        <title>Listado de Alumnos</title>
        <style>
          table { border-collapse: collapse; width: 100%; font-family: Arial, sans-serif; }
          th, td { border: 1px solid #999; padding: 6px 8px; text-align: left; }
          th { background: #eee; }
          tr.par { background-color: #f2f2f2; } /* filas pares */
          tr.impar { background-color: #ffffff; } /* filas impares */
        </style>
      </head>
      <body>
        <h1>Listado de Alumnos</h1>
        <table>
          <thead>
            <tr>
              <th>NIA</th>
              <th>nombre</th>
              <th>apellidos</th>
              <th>genero</th>
              <th>fecha_nacimiento</th>
              <th>ciclo</th>
              <th>curso</th>
              <th>grupo</th>
            </tr>
          </thead>
          <tbody>
            <!-- Recorre los alumnos -->
            <xsl:for-each select="alumno">
              <xsl:variable name="pos" select="position()"/>
              <!-- Alternar color según posición -->
              <xsl:choose>
                <xsl:when test="$pos mod 2 = 0">
                  <tr class="par">
                    <td><xsl:value-of select="@NIA"/></td>
                    <td><xsl:value-of select="@nombre"/></td>
                    <td><xsl:value-of select="@apellidos"/></td>
                    <td><xsl:value-of select="@genero"/></td>
                    <td><xsl:value-of select="@fecha_nacimiento"/></td>
                    <td><xsl:value-of select="@ciclo"/></td>
                    <td><xsl:value-of select="@curso"/></td>
                    <td><xsl:value-of select="@grupo"/></td>
                  </tr>
                </xsl:when>
                <xsl:otherwise>
                  <tr class="impar">
                    <td><xsl:value-of select="@NIA"/></td>
                    <td><xsl:value-of select="@nombre"/></td>
                    <td><xsl:value-of select="@apellidos"/></td>
                    <td><xsl:value-of select="@genero"/></td>
                    <td><xsl:value-of select="@fecha_nacimiento"/></td>
                    <td><xsl:value-of select="@ciclo"/></td>
                    <td><xsl:value-of select="@curso"/></td>
                    <td><xsl:value-of select="@grupo"/></td>
                  </tr>
                </xsl:otherwise>
              </xsl:choose>
            </xsl:for-each>
          </tbody>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
