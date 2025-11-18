<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- Salida HTML -->
	<xsl:output method="html" encoding="UTF-8" indent="yes" />

	<!-- Plantilla raíz -->
	<xsl:template match="/Alumnos">
		<html>
			<head>
				<meta charset="utf-8" />
				<title>Listado de Alumnos</title>
				<style>
					/* estilo básico */
					table { border-collapse: collapse; width: 100%; font-family: Arial,
					sans-serif; }
					th, td { border: 1px solid #999; padding: 6px 8px; text-align: left; }
					th { background: #eee; }
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
						<!-- Recorre cada alumno y escribe una fila -->
						<xsl:for-each select="alumno">
							<tr>
								<td>
									<xsl:value-of select="@NIA" />
								</td>
								<td>
									<xsl:value-of select="@nombre" />
								</td>
								<td>
									<xsl:value-of select="@apellidos" />
								</td>
								<td>
									<xsl:value-of select="@genero" />
								</td>
								<td>
									<xsl:value-of select="@fecha_nacimiento" />
								</td>
								<td>
									<xsl:value-of select="@ciclo" />
								</td>
								<td>
									<xsl:value-of select="@curso" />
								</td>
								<td>
									<xsl:value-of select="@grupo" />
								</td>
							</tr>
						</xsl:for-each>
					</tbody>
				</table>
			</body>
		</html>
	</xsl:template>

</xsl:stylesheet>
