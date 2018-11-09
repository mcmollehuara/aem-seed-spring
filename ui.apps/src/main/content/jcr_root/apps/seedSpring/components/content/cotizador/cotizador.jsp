<%@include file="/libs/foundation/global.jsp"%>
<%@taglib prefix="neba" uri="http://neba.io/1.0"%>
<neba:defineObjects />
<div id="pageDatos">
  <div class="container">
      <div class="row mg-bot-5">
          <div class="col s12 mg-top">
              <a class="link" style="cursor: pointer;">
                  <i class="material-icons"></i>
                  <span> regresar</span>
              </a>
          </div>
      </div>
      <div class="row mg-top-30 mg-bot-0">
          <div class="col s12 m8 l6 offset-m2 offset-l3 pad-top-10 pad-bot-40 white relative">
            
              <div class="col s12 m10 offset-m1 item-text-lg center">
                  <h2 class="title__name">Hola Para comenzar, ingresa estos datos</h2>
                  <p class="title__subtext"></p>
              </div>
              <div class="col s12 m10 l8 offset-m1 offset-l2">
                  <div class="col no-pad" style="width: 114px;">
                      <span class="mg-top mg-bot-5 input-no-label">
                          <div class="col input-field">
                              <div class="select-wrapper initialized">
                                  <span class="caret"></span>
                                  <input type="text" class="select-dropdown" readonly="true" data-activates="select-options-7800165d-a841-0c51-f286-ec99564ed21d"
                                      value="DNI">
                                  <ul id="select-options-7800165d-a841-0c51-f286-ec99564ed21d" class="dropdown-content select-dropdown ">
                                      <li class="">
                                          <span>DNI</span>
                                      </li>
                                      <li class="">
                                          <span>CE</span>
                                      </li>
                                  </ul>
                                  <select id="selDocType" class="initialized">
                                      <option value="2" selected="">DNI</option>
                                      <option value="4">CE</option>
                                  </select>
                              </div>
                          </div>
                      </span>
                  </div>
                  <div class="input-field col s12" style="width: calc(100% - 114px);">
                      <input type="text" id="nro_doc" class="validate valid" maxlength="12" style="background-color:#ffffff !important;" value="40290904">
                      <label id="titulo_nro_doc" for="nro_doc" class="active">DNI</label>
                  </div>
                  <p id="spn_nro_doc" class="col s12 span-error mg-top-8"></p>
                  <div class="input-field col s12">
                      <input type="text" id="placa_auto" class="validate" maxlength="6" style="background-color:#fff7b1 !important;" value="axy340">
                      <label for="placa_auto">Placa de carro</label>
                      <p id="spn_placa_auto" class="span-error"></p>
                  </div>
                  <div class="col s12 mg-top left-align">
                      <input type="checkbox" id="chkpolprotdatos" class="filled-in" value="on" checked="checked">
                      <label for="chkpolprotdatos" style="font-size: 12px; padding-left: 28px;">
                          <span>
                              <span class="label-check">Acepto la&nbsp;</span>
                          </span>
                      </label>
                      <a class="link-lightgrey">política de protección de datos seedSpringles</a>
                  </div>
              </div>
              <div class="col s12 calltoaction center" style="margin-top: 30px;">
                  <a id="btnCotizar" for="" class="btn-large calltoaction__btn--green">Cotizar</a>
              </div>
              <br>
          </div>
      </div>
  </div>
</div>

<div id="datosObtenidos" style="display:none">
  <div class="container">
      <div class="row mg-bot-5"></div>
      <div class="row center mg-top-30 mg-bot-0" id="SeccionConfirmacionDatos">
          <div class="col s12 m8 l6 offset-m2 offset-l3 pad-bot-5v pad-top-10 white">
              <div class="col s12">
                  <div class="item-text-lg">
                      <h2 class="title__name">Hola,
                          <span id="clienteName"></span>!</h2>
                  </div>
                  <div>Tu carro es un
                      <span id="detalle-vehiculo">
                          <strong><div id="marcaName"></div> <div id="modeloName"></div>, <div id="anio"></div></strong>
                      </span> de placa
                      <span id="placa-vehiculo">
                          <strong> <div id="placaNumero"></div></strong>
                      </span>?</div>
                  <div>
                      <a href="" id="btnCotizar" class="btn-large calltoaction__btn--green mg-top">Ok, Empecemos!</a>
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>
