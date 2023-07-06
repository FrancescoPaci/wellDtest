import { Component } from '@angular/core';
import { HttpService } from './services/http.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {

	constructor(private httpService: HttpService) { }

	lines: any = []
	allPoints: any = []
	linesWithXPoints: any = null
	newPoint: any = { x: '', y: '' }
	pointsNumber: number = 2
	decimalRegex: string = '(^[0-9]+[.]{1}[0-9]*$)|(^[1-9]{1}[0-9]*$)'

	ngOnInit() {
		this.getLines()
	}

	getLines() {
		this.httpService.callGet('getLines').subscribe(
			(data: any) => {
				this.lines = data
			},
			(error: any) => { },
			() => { }
		)
	}

	addPoint() {
		this.httpService.callPost('addPoint', this.newPoint).subscribe(
			(data: any) => {
				this.getLines()
				if (this.allPoints.length) {
					this.getAllPoints()
				}
				if (this.linesWithXPoints) {
					this.getLinesWithXPoints()
				}
			},
			(error: any) => { },
			() => { }
		)
	}

	getAllPoints() {
		this.httpService.callGet('getAllPoints').subscribe(
			(data: any) => {
				this.allPoints = data
			},
			(error: any) => { },
			() => { }
		)
	}

	reinitPoints() {
		this.httpService.callGet('reinitPoints').subscribe(
			(data: any) => {
				this.getLines()
				if (this.allPoints.length) {
					this.getAllPoints()
				}
				if (this.linesWithXPoints) {
					this.getLinesWithXPoints()
				}
			},
			(error: any) => { },
			() => { }
		)
	}

	removePoints() {
		this.httpService.callDelete('removePoints').subscribe(
			(data: any) => {
				this.getLines()
				if (this.allPoints.length) {
					this.getAllPoints()
				}
				if (this.linesWithXPoints) {
					this.getLinesWithXPoints()
				}
			},
			(error: any) => { },
			() => { }
		)
	}

	getLinesWithXPoints() {
		this.httpService.callGet('getLinesWithXPoints/' + this.pointsNumber).subscribe(
			(data: any) => {
				this.linesWithXPoints = data
			},
			(error: any) => { },
			() => { }
		)
	}


}

