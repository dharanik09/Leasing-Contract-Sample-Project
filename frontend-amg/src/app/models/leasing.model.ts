import { Customer } from "./customer.model";
import { Vehicle } from "./vehicle.model";

export class Leasing {

    id?: any;
    contractNumber?: string;
    monthlyRate?: string;
    customer?: Customer[];
    vehicle?:  Vehicle[];
    VIN: any;
    price: any;
    vehicle_id:any;
    customer_id:any;

}
