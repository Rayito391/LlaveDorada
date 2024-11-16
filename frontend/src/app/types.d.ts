export interface Cliente {
  numeroCliente: number;
  nombre: string;
  apellidoPaterno: string;
  apellidoMaterno: string;
  fechaNacimiento: string;
  domicilio: string;
  fechaRegistro: string;
  tipoCliente: TipoCliente;
}

export interface TipoCliente {
  numeroTipoCliente: number;
  descripcion: string;
  fechaRegistro: string;
}

export interface Categoria {
  numeroCategoria: number;
  descripcion: string;
  fechaRegistro: string;
}

export interface Producto {
  numeroProducto: number;
  descripcion: string;
  precio: number;
  existencia: number;
  fechaRegistro: string;
  activo: boolean;
  categoria: Categoria;
}

export interface TipoUsuario {
  numeroTipoUsuario: number;
  descripcionTipoUsuario: "Operador" | "Administrador";
  fechaRegistro: string;
}

export interface Usuario {
  numeroUsuario: number;
  nombre: string;
  apellidoPaterno: string;
  apellidoMaterno: string;
  fechaRegistro: string;
  tipoUsuario: TipoUsuario;
}

export interface DetalleVenta {
  numeroDetalleventa: number;
  cantidad: number;
  venta: Venta;
  producto: Producto;
}

export interface Venta {
  numeroVenta: number;
  total: number;
  fechaVenta: string;
  cliente: Cliente;
  detalleVentas: DetalleVenta[];
}
