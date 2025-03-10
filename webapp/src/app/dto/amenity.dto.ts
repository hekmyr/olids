export class AmenityDTO {
  id: string;
  airConditioningAvailable: boolean;
  terraceAvailable: boolean;
  gardenAvailable: boolean;
  poolAvailable: boolean;
  hotTubAvailable: boolean;
  evChargerAvailable: boolean;
  indoorFireplaceAvailable: boolean;
  outdoorFireplaceAvailable: boolean;
  dedicatedWorkspaceAvailable: boolean;
  gymAvailable: boolean;

  constructor(
    id: string,
    airConditioningAvailable: boolean,
    terraceAvailable: boolean,
    gardenAvailable: boolean,
    poolAvailable: boolean,
    hotTubAvailable: boolean,
    evChargerAvailable: boolean,
    indoorFireplaceAvailable: boolean,
    outdoorFireplaceAvailable: boolean,
    dedicatedWorkspaceAvailable: boolean,
    gymAvailable: boolean
  ) {
    this.id = id;
    this.airConditioningAvailable = airConditioningAvailable;
    this.terraceAvailable = terraceAvailable;
    this.gardenAvailable = gardenAvailable;
    this.poolAvailable = poolAvailable;
    this.hotTubAvailable = hotTubAvailable;
    this.evChargerAvailable = evChargerAvailable;
    this.indoorFireplaceAvailable = indoorFireplaceAvailable;
    this.outdoorFireplaceAvailable = outdoorFireplaceAvailable;
    this.dedicatedWorkspaceAvailable = dedicatedWorkspaceAvailable;
    this.gymAvailable = gymAvailable;
  }
}
