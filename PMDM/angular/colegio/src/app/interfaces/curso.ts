import { Asignatura } from "./asignatura"

export interface Curso {
    id: number
    nombre: string
    tipo: string
    horasTotales: number
    asignaturas: Asignatura[]
}
