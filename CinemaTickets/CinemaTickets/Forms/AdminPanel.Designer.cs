namespace CinemaTickets
{
    partial class AdminPanel
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.txtidfilm = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btsearch = new System.Windows.Forms.Button();
            this.pictbox = new System.Windows.Forms.PictureBox();
            this.txtnamefilm = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.btupdate = new System.Windows.Forms.Button();
            this.btdelete = new System.Windows.Forms.Button();
            this.btimage = new System.Windows.Forms.Button();
            this.addfilm = new System.Windows.Forms.Button();
            this.btaddimage = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.txtnamefilm2 = new System.Windows.Forms.TextBox();
            this.pictbox2 = new System.Windows.Forms.PictureBox();
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.txtduration2 = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.txtduration = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.dttimeadd = new System.Windows.Forms.DateTimePicker();
            this.label3 = new System.Windows.Forms.Label();
            this.dtdate = new System.Windows.Forms.DateTimePicker();
            this.btback = new System.Windows.Forms.Button();
            this.dttime = new System.Windows.Forms.DateTimePicker();
            this.dtdate2 = new System.Windows.Forms.DateTimePicker();
            this.dttime2 = new System.Windows.Forms.DateTimePicker();
            this.dtdate3 = new System.Windows.Forms.DateTimePicker();
            this.dttime3 = new System.Windows.Forms.DateTimePicker();
            this.dttimeadd2 = new System.Windows.Forms.DateTimePicker();
            this.dttimeadd3 = new System.Windows.Forms.DateTimePicker();
            ((System.ComponentModel.ISupportInitialize)(this.pictbox)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictbox2)).BeginInit();
            this.SuspendLayout();
            // 
            // txtidfilm
            // 
            this.txtidfilm.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtidfilm.Location = new System.Drawing.Point(16, 203);
            this.txtidfilm.Name = "txtidfilm";
            this.txtidfilm.Size = new System.Drawing.Size(242, 35);
            this.txtidfilm.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 166);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(79, 25);
            this.label1.TabIndex = 1;
            this.label1.Text = "ID Film";
            // 
            // btsearch
            // 
            this.btsearch.Location = new System.Drawing.Point(16, 246);
            this.btsearch.Name = "btsearch";
            this.btsearch.Size = new System.Drawing.Size(242, 49);
            this.btsearch.TabIndex = 2;
            this.btsearch.Text = "Search";
            this.btsearch.UseVisualStyleBackColor = true;
            this.btsearch.Click += new System.EventHandler(this.btsearch_Click);
            // 
            // pictbox
            // 
            this.pictbox.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.pictbox.Location = new System.Drawing.Point(422, 111);
            this.pictbox.Name = "pictbox";
            this.pictbox.Size = new System.Drawing.Size(172, 246);
            this.pictbox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictbox.TabIndex = 6;
            this.pictbox.TabStop = false;
            // 
            // txtnamefilm
            // 
            this.txtnamefilm.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtnamefilm.Location = new System.Drawing.Point(598, 132);
            this.txtnamefilm.Name = "txtnamefilm";
            this.txtnamefilm.Size = new System.Drawing.Size(242, 35);
            this.txtnamefilm.TabIndex = 7;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(598, 105);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(114, 25);
            this.label2.TabIndex = 10;
            this.label2.Text = "Film Name";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(598, 292);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(0, 25);
            this.label4.TabIndex = 12;
            // 
            // btupdate
            // 
            this.btupdate.Location = new System.Drawing.Point(603, 421);
            this.btupdate.Name = "btupdate";
            this.btupdate.Size = new System.Drawing.Size(114, 49);
            this.btupdate.TabIndex = 14;
            this.btupdate.Text = "Update";
            this.btupdate.UseVisualStyleBackColor = true;
            this.btupdate.Click += new System.EventHandler(this.btupdate_Click);
            // 
            // btdelete
            // 
            this.btdelete.Location = new System.Drawing.Point(723, 421);
            this.btdelete.Name = "btdelete";
            this.btdelete.Size = new System.Drawing.Size(114, 49);
            this.btdelete.TabIndex = 15;
            this.btdelete.Text = "Delete";
            this.btdelete.UseVisualStyleBackColor = true;
            this.btdelete.Click += new System.EventHandler(this.btdelete_Click);
            // 
            // btimage
            // 
            this.btimage.Location = new System.Drawing.Point(422, 362);
            this.btimage.Name = "btimage";
            this.btimage.Size = new System.Drawing.Size(172, 49);
            this.btimage.TabIndex = 16;
            this.btimage.Text = "Change Image";
            this.btimage.UseVisualStyleBackColor = true;
            this.btimage.Click += new System.EventHandler(this.btimage_Click);
            // 
            // addfilm
            // 
            this.addfilm.Location = new System.Drawing.Point(1141, 438);
            this.addfilm.Name = "addfilm";
            this.addfilm.Size = new System.Drawing.Size(242, 49);
            this.addfilm.TabIndex = 17;
            this.addfilm.Text = "Add New Film";
            this.addfilm.UseVisualStyleBackColor = true;
            this.addfilm.Click += new System.EventHandler(this.addfilm_Click);
            // 
            // btaddimage
            // 
            this.btaddimage.Location = new System.Drawing.Point(958, 362);
            this.btaddimage.Name = "btaddimage";
            this.btaddimage.Size = new System.Drawing.Size(172, 49);
            this.btaddimage.TabIndex = 25;
            this.btaddimage.Text = "Add Image";
            this.btaddimage.UseVisualStyleBackColor = true;
            this.btaddimage.Click += new System.EventHandler(this.btaddimage_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.Location = new System.Drawing.Point(1136, 111);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(114, 25);
            this.label8.TabIndex = 22;
            this.label8.Text = "Film Name";
            // 
            // txtnamefilm2
            // 
            this.txtnamefilm2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtnamefilm2.Location = new System.Drawing.Point(1142, 138);
            this.txtnamefilm2.Name = "txtnamefilm2";
            this.txtnamefilm2.Size = new System.Drawing.Size(242, 35);
            this.txtnamefilm2.TabIndex = 19;
            // 
            // pictbox2
            // 
            this.pictbox2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.pictbox2.Location = new System.Drawing.Point(958, 111);
            this.pictbox2.Name = "pictbox2";
            this.pictbox2.Size = new System.Drawing.Size(172, 246);
            this.pictbox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictbox2.TabIndex = 18;
            this.pictbox2.TabStop = false;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label10.Location = new System.Drawing.Point(952, 49);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(230, 37);
            this.label10.TabIndex = 27;
            this.label10.Text = "Add New Film";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label9.Location = new System.Drawing.Point(414, 49);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(307, 37);
            this.label9.TabIndex = 28;
            this.label9.Text = "Update/Delete Film";
            // 
            // txtduration2
            // 
            this.txtduration2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtduration2.Location = new System.Drawing.Point(1142, 246);
            this.txtduration2.Name = "txtduration2";
            this.txtduration2.Size = new System.Drawing.Size(242, 35);
            this.txtduration2.TabIndex = 33;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(1137, 212);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(93, 25);
            this.label5.TabIndex = 34;
            this.label5.Text = "Duration";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(600, 212);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(93, 25);
            this.label6.TabIndex = 35;
            this.label6.Text = "Duration";
            // 
            // txtduration
            // 
            this.txtduration.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtduration.Location = new System.Drawing.Point(603, 242);
            this.txtduration.Name = "txtduration";
            this.txtduration.Size = new System.Drawing.Size(242, 35);
            this.txtduration.TabIndex = 36;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(1137, 312);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(60, 25);
            this.label7.TabIndex = 23;
            this.label7.Text = "Time";
            // 
            // dttimeadd
            // 
            this.dttimeadd.CustomFormat = "HH:mm";
            this.dttimeadd.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dttimeadd.Location = new System.Drawing.Point(1142, 342);
            this.dttimeadd.Name = "dttimeadd";
            this.dttimeadd.Size = new System.Drawing.Size(206, 26);
            this.dttimeadd.TabIndex = 32;
            this.dttimeadd.Value = new System.DateTime(2024, 4, 12, 17, 40, 49, 0);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(603, 295);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(213, 25);
            this.label3.TabIndex = 11;
            this.label3.Text = "Show Date and Time";
            // 
            // dtdate
            // 
            this.dtdate.CustomFormat = "dd/MM/yyyy HH:mm";
            this.dtdate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtdate.Location = new System.Drawing.Point(603, 322);
            this.dtdate.Name = "dtdate";
            this.dtdate.Size = new System.Drawing.Size(114, 26);
            this.dtdate.TabIndex = 31;
            this.dtdate.Value = new System.DateTime(2024, 4, 12, 17, 40, 49, 0);
            // 
            // btback
            // 
            this.btback.Location = new System.Drawing.Point(28, 12);
            this.btback.Name = "btback";
            this.btback.Size = new System.Drawing.Size(121, 59);
            this.btback.TabIndex = 37;
            this.btback.Text = "Back";
            this.btback.UseVisualStyleBackColor = true;
            this.btback.Click += new System.EventHandler(this.btback_Click_1);
            // 
            // dttime
            // 
            this.dttime.CustomFormat = "HH:mm";
            this.dttime.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dttime.Location = new System.Drawing.Point(723, 322);
            this.dttime.Name = "dttime";
            this.dttime.Size = new System.Drawing.Size(114, 26);
            this.dttime.TabIndex = 38;
            this.dttime.Value = new System.DateTime(2024, 4, 24, 0, 0, 0, 0);
            // 
            // dtdate2
            // 
            this.dtdate2.CustomFormat = "dd/MM/yyyy HH:mm";
            this.dtdate2.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtdate2.Location = new System.Drawing.Point(603, 354);
            this.dtdate2.Name = "dtdate2";
            this.dtdate2.Size = new System.Drawing.Size(114, 26);
            this.dtdate2.TabIndex = 39;
            this.dtdate2.Value = new System.DateTime(2024, 4, 12, 17, 40, 49, 0);
            // 
            // dttime2
            // 
            this.dttime2.CustomFormat = "HH:mm";
            this.dttime2.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dttime2.Location = new System.Drawing.Point(723, 354);
            this.dttime2.Name = "dttime2";
            this.dttime2.Size = new System.Drawing.Size(114, 26);
            this.dttime2.TabIndex = 40;
            this.dttime2.Value = new System.DateTime(2024, 4, 24, 0, 0, 0, 0);
            // 
            // dtdate3
            // 
            this.dtdate3.CustomFormat = "dd/MM/yyyy HH:mm";
            this.dtdate3.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtdate3.Location = new System.Drawing.Point(603, 385);
            this.dtdate3.Name = "dtdate3";
            this.dtdate3.Size = new System.Drawing.Size(114, 26);
            this.dtdate3.TabIndex = 41;
            this.dtdate3.Value = new System.DateTime(2024, 4, 12, 17, 40, 49, 0);
            // 
            // dttime3
            // 
            this.dttime3.CustomFormat = "HH:mm";
            this.dttime3.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dttime3.Location = new System.Drawing.Point(723, 389);
            this.dttime3.Name = "dttime3";
            this.dttime3.Size = new System.Drawing.Size(114, 26);
            this.dttime3.TabIndex = 42;
            this.dttime3.Value = new System.DateTime(2024, 4, 24, 0, 0, 0, 0);
            this.dttime3.ValueChanged += new System.EventHandler(this.dateTimePicker4_ValueChanged);
            // 
            // dttimeadd2
            // 
            this.dttimeadd2.CustomFormat = "HH:mm";
            this.dttimeadd2.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dttimeadd2.Location = new System.Drawing.Point(1142, 374);
            this.dttimeadd2.Name = "dttimeadd2";
            this.dttimeadd2.Size = new System.Drawing.Size(206, 26);
            this.dttimeadd2.TabIndex = 43;
            this.dttimeadd2.Value = new System.DateTime(2024, 4, 12, 17, 40, 49, 0);
            // 
            // dttimeadd3
            // 
            this.dttimeadd3.CustomFormat = "HH:mm";
            this.dttimeadd3.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dttimeadd3.Location = new System.Drawing.Point(1142, 406);
            this.dttimeadd3.Name = "dttimeadd3";
            this.dttimeadd3.Size = new System.Drawing.Size(206, 26);
            this.dttimeadd3.TabIndex = 44;
            this.dttimeadd3.Value = new System.DateTime(2024, 4, 12, 17, 40, 49, 0);
            // 
            // AdminPanel
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1370, 574);
            this.Controls.Add(this.dttimeadd3);
            this.Controls.Add(this.dttimeadd2);
            this.Controls.Add(this.dttime3);
            this.Controls.Add(this.dtdate3);
            this.Controls.Add(this.dttime2);
            this.Controls.Add(this.dtdate2);
            this.Controls.Add(this.dttime);
            this.Controls.Add(this.btback);
            this.Controls.Add(this.txtduration);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.txtduration2);
            this.Controls.Add(this.dttimeadd);
            this.Controls.Add(this.dtdate);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.btaddimage);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.txtnamefilm2);
            this.Controls.Add(this.pictbox2);
            this.Controls.Add(this.addfilm);
            this.Controls.Add(this.btimage);
            this.Controls.Add(this.btdelete);
            this.Controls.Add(this.btupdate);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtnamefilm);
            this.Controls.Add(this.pictbox);
            this.Controls.Add(this.btsearch);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtidfilm);
            this.Name = "AdminPanel";
            this.Text = "AdminPanel";
            ((System.ComponentModel.ISupportInitialize)(this.pictbox)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictbox2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtidfilm;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btsearch;
        private System.Windows.Forms.PictureBox pictbox;
        private System.Windows.Forms.TextBox txtnamefilm;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btupdate;
        private System.Windows.Forms.Button btdelete;
        private System.Windows.Forms.Button btimage;
        private System.Windows.Forms.Button addfilm;
        private System.Windows.Forms.Button btaddimage;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox txtnamefilm2;
        private System.Windows.Forms.PictureBox pictbox2;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.TextBox txtduration2;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox txtduration;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.DateTimePicker dttimeadd;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.DateTimePicker dtdate;
        private System.Windows.Forms.Button btback;
        private System.Windows.Forms.DateTimePicker dttime;
        private System.Windows.Forms.DateTimePicker dtdate2;
        private System.Windows.Forms.DateTimePicker dttime2;
        private System.Windows.Forms.DateTimePicker dtdate3;
        private System.Windows.Forms.DateTimePicker dttime3;
        private System.Windows.Forms.DateTimePicker dttimeadd2;
        private System.Windows.Forms.DateTimePicker dttimeadd3;
    }
}