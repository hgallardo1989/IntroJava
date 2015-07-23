package py.edu.uaa.finalTrabajo.graficos;
	
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import javax.swing.InputVerifier;
	import javax.swing.JComponent;
	import javax.swing.JOptionPane;
	import javax.swing.text.JTextComponent;


	public class ValidarEmail extends InputVerifier {
		public final static int EMAIL = 1;
		private Pattern pattern;
		private Matcher matcher;
		
		private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		private int longitudCadena = 0;
		private int tipoValidacion;
		
		public ValidarEmail() {
			tipoValidacion = EMAIL;
		}
		
		public ValidarEmail (int tipoValidacion){
			this.tipoValidacion = tipoValidacion;
		}
		
		public ValidarEmail (int longitudCadena, int tipoValidacion){
			this.longitudCadena = longitudCadena;
			this.tipoValidacion = tipoValidacion;
		}

		@Override
		public boolean verify(JComponent input) {
			JTextComponent cmp = (JTextComponent)input;
			String texto = cmp.getText();
			if(!texto.isEmpty()){
				switch(tipoValidacion){
				case EMAIL:
					if (longitudCadena == 0 || texto.length()<longitudCadena){
						if(esValido(texto)){
							return true;
						}
					}
				}
				
			}
			JOptionPane.showMessageDialog(null, "Email no es valido");
			return false;
		}
		
		public boolean esValido (String string){
			switch(tipoValidacion){
			case EMAIL:
				pattern = Pattern.compile(EMAIL_PATTERN);
				matcher = pattern.matcher(string);
				return matcher.matches();
				default:
					return false;
			}
		}
		
		

	}