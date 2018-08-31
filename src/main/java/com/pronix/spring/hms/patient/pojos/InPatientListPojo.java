package com.pronix.spring.hms.patient.pojos;

import com.pronix.spring.hms.patient.models.InpatientDetails;
import com.pronix.spring.hms.doctor.pojos.AppointmentsList;

public class InPatientListPojo {

	private InpatientDetails ipInpatientDetails;
	
	private AppointmentsList AppointmentsList;

	public InPatientListPojo() {
		super();
	}

	public InPatientListPojo(InpatientDetails ipInpatientDetails,
			com.pronix.spring.hms.doctor.pojos.AppointmentsList appointmentsList) {
		super();
		this.ipInpatientDetails = ipInpatientDetails;
		AppointmentsList = appointmentsList;
	}

	public InpatientDetails getIpInpatientDetails() {
		return ipInpatientDetails;
	}

	public void setIpInpatientDetails(InpatientDetails ipInpatientDetails) {
		this.ipInpatientDetails = ipInpatientDetails;
	}

	public AppointmentsList getAppointmentsList() {
		return AppointmentsList;
	}

	public void setAppointmentsList(AppointmentsList appointmentsList) {
		AppointmentsList = appointmentsList;
	}
	
}
