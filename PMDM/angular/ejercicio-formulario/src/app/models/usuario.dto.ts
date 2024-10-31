export class UsuarioDto{

    constructor(
        public nombre: string,
        public apellidos: string,
        public nif: string,
        public email: string,
        public tel: string,
        public sexo: string,
        public conocimientoPagina: string,
        public contrasena: string
    ){}
}