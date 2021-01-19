import axios from 'axios';

export class EmpleadoService {
    baseUrl = "http://localhost:8080/empleados/"; 

    getAll(){
        return axios.get(this.baseUrl + "").then( res => res.data)
    }

    save(empleado){
        return axios.post(this.baseUrl + "agregarEmpleado", empleado).then( res => res.data) 
    }
}


