import React, { Component } from 'react';
import './App.css';
import { EmpleadoService } from './service/EmpleadoService';
import { Column } from 'primereact/column';
import { DataTable } from 'primereact/datatable';
import { Panel } from 'primereact/panel';
import { Menubar } from 'primereact/menubar';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Toast } from 'primereact/toast';

import'primereact/resources/themes/nova/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

export default class App extends Component{
  constructor(){
    super();
    this.state = {
      visible : false,
      empleado : {
        nombre : null,
        apellido : null,
        dni : null,
        contrasenia : null,
        mail : null,
        rol : null
      }
    };
    this.items = [
      {
        label:'Nuevo',
        icon:'pi pi-fw pi-plus',
        command : () => {this.showSaveDialog()}
      },
      {
        label:'Editar',
        icon:'pi pi-fw pi-pencil',
        command : () => {alert('Editado!')}
      },
      {
        label:'Eliminar',
        icon:'pi pi-fw pi-trash',
        command : () => {alert('Eliminado!')}
      }
    ];
    this.empleadoService = new EmpleadoService();
    this.save = this.save.bind(this);
    this.footer = (
      <div>
        <Button label="Guardar" icon="pi pi-check" onClick={this.save}/>
      </div>
    );
    this.toast = {};
    
  }

  componentDidMount(){
    this.empleadoService.getAll().then(data => this.setState({empleados: data}))
    
  }

  save(){
    this.empleadoService.save(this.state.empleado).then( data => {
      this.setState({
        visible : false,
        empleado : {
          nombre : null,
          apellido : null,
          dni : null,
          contrasenia : null,
          mail : null,
          rol : null
        }
      });
      
      this.empleadoService.getAll().then(data => this.setState({empleados: data}))
      this.toast.current.show({severity: 'success', summary: 'Atención', detail: 'Empleado creado con éxito'});
    })
  }
  
  render(){
    return (
      <div style={{width:'80%',margin:'0 auto',marginTop:'40px'}}>
        <Menubar model={this.items}/>
        <br/>
        <Panel header="Prueba datatable React" >
          <DataTable value={this.state.empleados}>
            <Column field="id" header="ID"></Column>
            <Column field="nombre" header="Nombre"></Column>
            <Column field="apellido" header="Apellido"></Column>
            <Column field="dni" header="Dni"></Column>
            <Column field="contrasenia" header="Pass"></Column>
            <Column field="mail" header="Mail"></Column>
            <Column field="rol" header="Rol"></Column>
          </DataTable>
        </Panel>

        <Dialog header="Cargar un empleado" visible={this.state.visible} footer={this.footer} modal={true} style={{ width: '30vw'}} onHide={() => this.setState({visible: false})} >
          <form id="empleado-form" >
            <br/>
            <span className="p-float-label">

              <InputText style={{width : '100%'}} value={this.state.empleado.nombre} id="nombre" onChange={(e) => { 
                let val = e.target.value;
                
                this.setState(prevState => {
                  let empleado = Object.assign({}, prevState.empleado)
                  empleado.nombre = val;

                  return {empleado};
                })}
              } />
              <label htmlhtmlFor="nombre">Nombre</label>
            </span>
            <br/>
            <span className="p-float-label">

              <InputText style={{width : '100%'}} value={this.state.empleado.apellido} id="apellido" onChange={(e) => {  
                let val = e.target.value;

                this.setState(prevState => {
                  let empleado = Object.assign({}, prevState.empleado)
                  empleado.apellido = val;

                  return {empleado};
                })}
              } />
              <label htmlhtmlFor="apellido">Apellido</label>
            </span>

            <br/>
            <span className="p-float-label">

              <InputText style={{width : '100%'}} value={this.state.empleado.dni} id="dni" onChange={(e) => {
                let val = e.target.value;
                this.setState(prevState => {
                  let empleado = Object.assign({}, prevState.empleado)
                  empleado.dni = val;

                  return {empleado};
                })} 
              }/>
              <label htmlhtmlFor="dni">DNI</label>
            </span>

            <br/>
            <span className="p-float-label">

              <InputText style={{width : '100%'}} value={this.state.empleado.contrasenia} id="contrasenia" onChange={(e) => {
                  let val = e.target.value;
                  
                  this.setState(prevState => {
                    let empleado = Object.assign({}, prevState.empleado)
                    empleado.contrasenia = val;

                    return {empleado};
                })} 
              }/>
              <label htmlhtmlFor="contrasenia">Contraseña</label>
            </span>

            <br/>
            <span className="p-float-label">

              <InputText style={{width : '100%'}} value={this.state.empleado.mail} id="mail" onChange={(e) => {
                let val = e.target.value;

                this.setState(prevState => {
                  let empleado = Object.assign({}, prevState.empleado)
                  empleado.mail = val;

                  return {empleado};
                })}
              }/>
              <label htmlhtmlFor="mail">Mail</label>
            </span>

            <br/>
            <span className="p-float-label">

              <InputText style={{width : '100%'}} value={this.state.empleado.rol} id="rol" onChange={(e) => { 
                let val = e.target.value;

                this.setState(prevState => {
                  let empleado = Object.assign({}, prevState.empleado)
                  empleado.rol = val;

                  return {empleado};
                })}
              }/>
              <label htmlhtmlFor="rol">Rol</label>
            </span>
          </form>
        </Dialog>
        <Toast ref={this.toast} />
      </div>
    );
  }

  showSaveDialog(){
    this.setState({
      visible : true,
      empleado : {
        nombre : null,
        apellido : null,
        dni : null,
        contrasenia : null,
        mail : null,
        rol : null
      }
    });
    // document.getElementById('empleado-form').reset();
  }
}